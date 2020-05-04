package ru.stepanov.auth.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RestController;
import ru.stepanov.core.endpoints.AbstractMicroservice;
import ru.stepanov.core.util.RLUCache;
import ru.stepanov.database.DatabaseService;
import ru.stepanov.route.auth.interfaces.IAuthenticationService;
import ru.stepanov.route.auth.models.LogoutResponse;
import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.auth.models.cutter.*;
import ru.stepanov.route.exceptions.MicroServiceException;

import javax.annotation.PostConstruct;

@Primary
@RestController
public class AuthenticationEndpoint extends AbstractMicroservice implements IAuthenticationService {

    @Autowired
    private DatabaseService databaseService;

    private RLUCache<String, String> tokensCache;

    @PostConstruct
    private void initialize() {
        int ttl = 60_000;
        int max = 10_000;

        tokensCache = new RLUCache<>(ttl, max);
    }

    @Override
    public CustomerModel customerInfo(AuthCustomerInfoRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CustomerModel customerSignUp(AuthCustomerSignUpRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public CustomerModel customerLogin(AuthCustomerLoginRequest request) throws MicroServiceException {
        return null;
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
        return null;
    }

    @Override
    public CutterModel cutterLogin(AuthCutterLoginRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public LogoutResponse cutterLogout(AuthCutterLogoutRequest request) throws MicroServiceException {
        return null;
    }
}
