package com.pgg.account.exception;

import lombok.Getter;

import java.util.IllegalFormatException;


@Getter
public class IssueType {

    public static final IssueType UNEXPECTED_ERROR =
            new IssueType("0", "Unexpected error occurred, please contact the system administrator.");
    public static final IssueType SERVICE_UNAVAILABLE =
            new IssueType("1", "Sorry, our service is unavailable/unstable at the moment.");
    public static final IssueType SERVICE_RETRY_TIMEOUT =
            new IssueType("2", "The service response took too long.");
    public static final IssueType BAD_REQUEST =
            new IssueType("5", "Invalid request.");
    public static final IssueType ACCOUNT_NOT_FOUND =
            new IssueType("15", "Account not found.");
    public static final IssueType ACCOUNT_BAD_REQUEST =
            new IssueType("18", "Invalid account.");
    public static final IssueType ACCOUNT_EXISTS =
            new IssueType("21", "Account already exists with username or email.");

    private final String code;
    private final String message;

    IssueType(String code, String message) {
        this.code = code;
        this.message = message;
    }



    public String getFormattedMessage(final Object... args) {

        if (message == null) {
            return "";
        }

        try {
            return String.format(message, args);
        } catch (final IllegalFormatException e) {
            return message.replace("%s", "");
        }
    }


}