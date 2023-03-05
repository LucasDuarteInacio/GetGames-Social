package com.pgg.account.vo;


import com.pgg.account.annotations.ValidEmail;
import com.pgg.account.annotations.ValidPassword;
import com.pgg.account.dto.enums.RegistrationMethodEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {



    @NotBlank(message =  "must not be blank")
    @Size(min=3, max=15)
    @Schema(description = "Account firstName", example = "Lucas")
    private String firstName;

    @NotBlank(message =  "must not be blank")
    @Size(min=3, max=15)
    @Schema(description = "Account lastName", example = "Duarte")
    private String lastName;

//    @NotBlank(message =  "must not be blank")
    @Schema(description = "Account birthday", example = "2015-03-01")
    private LocalDate birthday;

    @ValidEmail
    @Schema(description = "Account email", example = "jonhDoe@email.com")
    private String email;

    @ValidPassword(message = "must not be blank" )
    @Schema(description = "Password must be 8 to 20 characters long and contain numbers and special characters",  example = "@Pass2022")
    private String password;

    @NotNull(message = "must not be blank")
    @Schema(description = "User registration method on the platform",  example = "WEB")
    private RegistrationMethodEnum registrationMethod;

}
