package ru.stepanov.auth.endpoints;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.apache.cayenne.query.SelectById;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.stepanov.auth.util.PasswordHelper;
import ru.stepanov.core.endpoints.AbstractMicroservice;
import ru.stepanov.core.util.RLUCache;
import ru.stepanov.database.DatabaseService;
import ru.stepanov.database.entity.*;
import ru.stepanov.route.auth.interfaces.IAuthenticationService;
import ru.stepanov.route.auth.models.LogoutResponse;
import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.auth.models.cutter.*;
import ru.stepanov.route.exceptions.MicroServiceException;
import ru.stepanov.route.exceptions.MsBadRequestException;
import ru.stepanov.route.exceptions.MsNotAuthorizedException;
import ru.stepanov.route.exceptions.MsObjectNotFoundException;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Primary
@RestController
public class AuthenticationEndpoint extends AbstractMicroservice implements IAuthenticationService {

    @Autowired
    private DatabaseService databaseService;

    ObjectContext objectContext;

    protected static final Logger log = LoggerFactory.getLogger(AuthenticationEndpoint.class);

    private RLUCache<String, String> tokensCache;

    @PostConstruct
    private void initialize() {
        int ttl = 60_000;
        int max = 10_000;
        tokensCache = new RLUCache<>(ttl, max);

        objectContext = databaseService.getContext();
    }

    @Override
    public CustomerModel customerInfo(AuthCustomerInfoRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CustomerModel customerSignUp(AuthCustomerSignUpRequest request) throws MicroServiceException {
        if (checkCustomerEmailExists(request.getEmail())) {

            DbCustomer customer = objectContext.newObject(DbCustomer.class);

            customer.setCreatedDate(LocalDateTime.now());
            customer.setFirstName(request.getFirstName());
            customer.setLastName(request.getLastName());
            customer.setEmail(request.getEmail());
            customer.setPhone(request.getPhone());
            customer.setSalt(PasswordHelper.generateSalt());
            customer.setPassword(PasswordHelper.hashPassword(request.getPassword(), customer.getSalt()));

            DbAddress address = SelectById.query(DbAddress.class, 1).selectFirst(objectContext);
            customer.setCustomerToAddress(address);

            objectContext.commitChanges();

            return CustomerModel.builder()
                    .id((Long) customer.getObjectId().getIdSnapshot().get("id"))
                    .email(customer.getEmail())
                    .phone(customer.getPhone())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .idAddress((Long) customer.getCustomerToAddress().getObjectId().getIdSnapshot().get("id"))
                    .build();

        } else
            throw new MsBadRequestException(request.getEmail());
    }

    @Override
    public CustomerModel customerLogin(AuthCustomerLoginRequest request) throws MicroServiceException {
        if (checkCustomerEmailExists(request.getEmail())) {

            DbCustomer customer = ObjectSelect.query(DbCustomer.class)
                    .where(DbCustomer.EMAIL.eq(request.getEmail()))
                    .selectFirst(objectContext);

            if (customer.getPassword().equals(PasswordHelper.hashPassword(request.getPassword(), customer.getSalt()))) {

                DbCustomerSession session = objectContext.newObject(DbCustomerSession.class);
                session.setCreatedDate(LocalDateTime.now());
                session.setSessionToCustomer(customer);

                objectContext.commitChanges();

                return CustomerModel.builder()
                        .id((Long) customer.getObjectId().getIdSnapshot().get("id"))
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .idAddress((Long) customer.getCustomerToAddress().getObjectId().getIdSnapshot().get("id"))
                        .build();

            } else
                throw new MsNotAuthorizedException();
        } else
            throw new MsObjectNotFoundException("Customer with email: ", request.getEmail());
    }

    @Override
    public LogoutResponse customerLogout(AuthCustomerLogoutRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CutterModel cutterInfo(AuthCutterInfoRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CutterModel cutterSignUp(AuthCutterSignUpRequest request) throws MicroServiceException {
        if (checkCutterEmailExists(request.getEmail())) {

            DbCutter cutter = objectContext.newObject(DbCutter.class);

            cutter.setCreatedDate(LocalDateTime.now());
            cutter.setFirstName(request.getFirstName());
            cutter.setLastName(request.getLastName());
            cutter.setEmail(request.getEmail());
            cutter.setPhone(request.getPhone());
            cutter.setSalt(PasswordHelper.generateSalt());
            cutter.setPassword(PasswordHelper.hashPassword(request.getPassword(), cutter.getSalt()));

            DbAddress address = SelectById.query(DbAddress.class, 1).selectFirst(objectContext);
            cutter.setCutterToAddress(address);

            objectContext.commitChanges();

            return CutterModel.builder()
                    .id((Long) cutter.getObjectId().getIdSnapshot().get("id"))
                    .email(cutter.getEmail())
                    .phone(cutter.getPhone())
                    .firstName(cutter.getFirstName())
                    .lastName(cutter.getLastName())
                    .idAddress((Long) cutter.getCutterToAddress().getObjectId().getIdSnapshot().get("id"))
                    .build();

        } else
            throw new MsBadRequestException(request.getEmail());
    }

    @Override
    public CutterModel cutterLogin(AuthCutterLoginRequest request) throws MicroServiceException {
        if (checkCutterEmailExists(request.getEmail())) {

            DbCutter cutter = ObjectSelect.query(DbCutter.class)
                    .where(DbCutter.EMAIL.eq(request.getEmail()))
                    .selectFirst(objectContext);

            if (cutter.getPassword().equals(PasswordHelper.hashPassword(request.getPassword(), cutter.getSalt()))) {

                DbCutterSession session = objectContext.newObject(DbCutterSession.class);
                session.setCreatedDate(LocalDateTime.now());
                session.setSessionToCutter(cutter);

                objectContext.commitChanges();

                return CutterModel.builder()
                        .id((Long) cutter.getObjectId().getIdSnapshot().get("id"))
                        .email(cutter.getEmail())
                        .phone(cutter.getPhone())
                        .firstName(cutter.getFirstName())
                        .lastName(cutter.getLastName())
                        .idAddress((Long) cutter.getCutterToAddress().getObjectId().getIdSnapshot().get("id"))
                        .build();

            } else
                throw new MsNotAuthorizedException();
        } else
            throw new MsObjectNotFoundException("Cutter with email: ", request.getEmail());
    }

    @Override
    public LogoutResponse cutterLogout(AuthCutterLogoutRequest request) throws MicroServiceException {
        return null;
    }


    private boolean checkCutterEmailExists(String email) {
        try {
            DbCutter cutter = ObjectSelect.query(DbCutter.class)
                    .where(DbCutter.EMAIL.eq(email))
                    .selectFirst(objectContext);

            return cutter != null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return true;
        }
    }

    private boolean checkCustomerEmailExists(String email) {
        try {
            DbCustomer customer = ObjectSelect.query(DbCustomer.class)
                    .where(DbCustomer.EMAIL.eq(email))
                    .selectFirst(objectContext);

            return customer != null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return true;
        }
    }
}
