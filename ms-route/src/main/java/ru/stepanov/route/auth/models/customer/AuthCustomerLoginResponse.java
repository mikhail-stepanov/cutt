package ru.stepanov.route.auth.models.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCustomerLoginResponse {

    private String token;

    private String userId;

    private String userName;
}
