package ru.stepanov.ms.client.auth.services;

import ru.stepanov.ms.client.auth.models.*;
import ru.stepanov.ms.client.common.services.BaseMicroservice;
import ru.stepanov.ms.client.exceptions.MicroServiceException;
import ru.stepanov.ms.client.auth.interfaces.IAuthenticationService;
import ru.stepanov.ms.client.auth.models.*;
import org.springframework.web.client.RestTemplate;


public class AuthenticationService extends BaseMicroservice implements IAuthenticationService {

    public AuthenticationService(RestTemplate restTemplate) {
        super("ms-auth", restTemplate);
    }

    @Override
    public AuthInfoResponse info(AuthInfoRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_INFO), request, AuthInfoResponse.class).getBody());
    }

    @Override
    public AuthLoginResponse signUp(AuthSignUpRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_SIGNUP), request, AuthLoginResponse.class).getBody());
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_LOGIN), request, AuthLoginResponse.class).getBody());
    }

    @Override
    public AuthLogoutResponse logout(AuthLogoutRequest request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_LOGOUT), request, AuthLogoutResponse.class).getBody());
    }

    @Override
    public String password(String request) throws MicroServiceException {
        return retry(() -> restTemplate.postForEntity(buildUrl(AUTH_PASSWORD), request, String.class).getBody());
    }
}
