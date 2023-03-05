package com.pgg.account.vo;

import com.pgg.account.dto.enums.AccountStatusEnum;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountFilterRequest {


    private String accountId;
    private String username;
    private String email;
    private AccountStatusEnum status;


}
