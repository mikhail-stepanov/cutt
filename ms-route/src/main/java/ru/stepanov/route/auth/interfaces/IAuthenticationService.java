package ru.stepanov.route.auth.interfaces;

import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.exceptions.MicroServiceException;

public interface IAuthenticationService {

    String AUTH_CUSTOMER_INFO = "/auth/customer/info";
    String AUTH_CUSTOMER_SIGN_UP = "/auth/customer/signup";
    String AUTH_CUSTOMER_LOGIN = "/auth/customer/login";
    String AUTH_CUSTOMER_LOGOUT = "/auth/customer/logout";

    String AUTH_CUTTER_INFO = "/auth/cutter/info";
    String AUTH_CUTTER_SIGN_UP = "/auth/cutter/signup";
    String AUTH_CUTTER_LOGIN = "/auth/cutter/login";
    String AUTH_CUTTER_LOGOUT = "/auth/cutter/logout";

    AuthCustomerInfoResponse info(AuthCustomerInfoRequest request) throws MicroServiceException;

    AuthCustomerLoginResponse signUp(AuthCustomerSignUpRequest request) throws MicroServiceException;

    AuthCustomerLoginResponse login(AuthCustomerLoginRequest request) throws MicroServiceException;

    AuthCustomerLogoutResponse logout(AuthCustomerLogoutRequest request) throws MicroServiceException;

    String password(String request) throws MicroServiceException;

}
