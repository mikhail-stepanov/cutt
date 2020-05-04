package ru.stepanov.route.auth.models.cutter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CutterModel {

    Long id;

    String email;

    String phone;

    String firstName;

    String lastName;

    Long idAddress;

    String password;

    String salt;

    LocalDateTime createdDate;

    LocalDateTime modifiedDate;

    LocalDateTime deletedDate;
}
