package com.pgg.account.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pgg.account.domain.Profile;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private String accountId;
    private String username;
    private String email;
    private String status;
    private String registrationDate;
    private Profile profile;

}
