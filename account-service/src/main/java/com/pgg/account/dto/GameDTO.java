package com.pgg.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private String gameId;
    private String title;
    private Set<String> genre;
    private Set<String> developer;
    private Set<String> publisher;
    private Set<String> platform;
    private LocalDate release;
    private String image;
    private boolean status;
}
