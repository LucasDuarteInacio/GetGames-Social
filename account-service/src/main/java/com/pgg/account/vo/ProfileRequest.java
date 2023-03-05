package com.pgg.account.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {


    @Schema(description = "First name", example = "Lucas")
    private String firstName;

    @Schema(description = "Last Name", example = "Duarte")
    private String lastName;

    @Schema(description = "Country", example = "BR")
    private String country;

    @Schema(description = "About", example = "a passionate gamer")
    private String about;

    @Schema(description = "Phone number", example = "+5531991242489")
    private String phoneNumber;

    @Schema(description = "Birthday", example = "1994-11-25")
    private LocalDate birthday;

    @Schema(description = "Playstation id", example = "PsId")
    private String psId;

    @Schema(description = "Xbox id", example = "XbId")
    private String xbId;

    @Schema(description = "Steam id", example = "SteamId")
    private String steamId;
}
