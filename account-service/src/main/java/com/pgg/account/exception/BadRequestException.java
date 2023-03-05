package com.pgg.account.exception;

public class BadRequestException extends ApiException {

    public BadRequestException(final Issue issue) {
        super(issue);
    }

    public static BadRequestException invalaccountId() {
        return new BadRequestException(new Issue(IssueType.ACCOUNT_BAD_REQUEST));
    }

    public static BadRequestException existsAccount() {
        return new BadRequestException(new Issue(IssueType.ACCOUNT_EXISTS));
    }


}
