package ru.stepanov.route.auth.models.cutter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCutterInfoResponse {

    private String userId;

    private String userName;

}
