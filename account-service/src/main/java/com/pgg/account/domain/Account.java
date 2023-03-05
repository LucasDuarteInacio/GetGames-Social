package com.pgg.account.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String accountId;
    private String username;
    private String email;
    private String password;
    private String status;
    private String registrationMethod;
    private LocalDate registrationDate;
    private Profile profile;

}
