package ru.stepanov.route.auth.models.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCustomerSignUpRequest {

    @NotNull
    String email;

    @NotNull
    String password;

    @NotNull
    String phone;
    
    String firstName;

    String lastName;
}
