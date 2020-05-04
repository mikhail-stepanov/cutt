package ru.stepanov.route.auth.services;

import org.springframework.web.client.RestTemplate;
import ru.stepanov.route.auth.interfaces.IAuthenticationService;
import ru.stepanov.route.auth.models.LogoutResponse;
import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.auth.models.cutter.*;
import ru.stepanov.route.common.services.BaseMicroservice;
import ru.stepanov.route.exceptions.MicroServiceException;


public class AuthenticationService extends BaseMicroservice implements IAuthenticationService {

    public AuthenticationService(RestTemplate restTemplate) {
        super("ms-auth", restTemplate);
    }

    @Override
    public CustomerModel customerInfo(AuthCustomerInfoRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUSTOMER_INFO), request, CustomerModel.class).getBody());
    }

    @Override
    public CustomerModel customerSignUp(AuthCustomerSignUpRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUSTOMER_SIGN_UP), request, CustomerModel.class).getBody());
    }

    @Override
    public CustomerModel customerLogin(AuthCustomerLoginRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUSTOMER_LOGIN), request, CustomerModel.class).getBody());
    }

    @Override
    public LogoutResponse customerLogout(AuthCustomerLogoutRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUSTOMER_LOGOUT), request, LogoutResponse.class).getBody());
    }

    @Override
    public CutterModel cutterInfo(AuthCutterInfoRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUTTER_INFO), request, CutterModel.class).getBody());
    }

    @Override
    public CutterModel cutterSignUp(AuthCutterSignUpRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUTTER_SIGN_UP), request, CutterModel.class).getBody());
    }

    @Override
    public CutterModel cutterLogin(AuthCutterLoginRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUTTER_LOGIN), request, CutterModel.class).getBody());
    }

    @Override
    public LogoutResponse cutterLogout(AuthCutterLogoutRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_CUTTER_LOGOUT), request, LogoutResponse.class).getBody());
    }
}
