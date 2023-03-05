package com.pgg.account.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardError {

    private String code;
    private String message;
    private Long timesTamp;
    private String path;
}
