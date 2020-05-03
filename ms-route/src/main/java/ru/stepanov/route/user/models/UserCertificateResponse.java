package ru.stepanov.route.user.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCertificateResponse {

    private String id;

    private String cn;

    private String thumbprint;
}
