package ru.stepanov.route.auth.models.cutter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCutterSignUpRequest {

    @NotNull
    String email;

    @NotNull
    String password;

    @NotNull
    String phone;

    String firstName;

    String lastName;

}
