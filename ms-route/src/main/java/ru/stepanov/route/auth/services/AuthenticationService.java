package ru.stepanov.route.auth.services;

import org.springframework.web.client.RestTemplate;
import ru.stepanov.route.auth.interfaces.IAuthenticationService;
import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.common.services.BaseMicroservice;
import ru.stepanov.route.exceptions.MicroServiceException;


public class AuthenticationService extends BaseMicroservice implements IAuthenticationService {

    public AuthenticationService(RestTemplate restTemplate) {
        super("ms-auth", restTemplate);
    }


    @Override
    public AuthCustomerInfoResponse info(AuthCustomerInfoRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public AuthCustomerLoginResponse signUp(AuthCustomerSignUpRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public AuthCustomerLoginResponse login(AuthCustomerLoginRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public AuthCustomerLogoutResponse logout(AuthCustomerLogoutRequest request) throws MicroServiceException {
        return null;
    }

    @Override
    public String password(String request) throws MicroServiceException {
        return null;
    }
}
