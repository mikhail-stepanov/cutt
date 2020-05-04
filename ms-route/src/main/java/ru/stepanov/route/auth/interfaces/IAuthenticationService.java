package ru.stepanov.route.auth.interfaces;

import ru.stepanov.route.auth.models.LogoutResponse;
import ru.stepanov.route.auth.models.customer.*;
import ru.stepanov.route.auth.models.cutter.*;
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

    CustomerModel customerInfo(AuthCustomerInfoRequest request) throws MicroServiceException;

    CustomerModel customerSignUp(AuthCustomerSignUpRequest request) throws MicroServiceException;

    CustomerModel customerLogin(AuthCustomerLoginRequest request) throws MicroServiceException;

    LogoutResponse customerLogout(AuthCustomerLogoutRequest request) throws MicroServiceException;


    CutterModel cutterInfo(AuthCutterInfoRequest request) throws MicroServiceException;

    CutterModel cutterSignUp(AuthCutterSignUpRequest request) throws MicroServiceException;

    CutterModel cutterLogin(AuthCutterLoginRequest request) throws MicroServiceException;

    LogoutResponse cutterLogout(AuthCutterLogoutRequest request) throws MicroServiceException;


}
