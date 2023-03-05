package com.pgg.account.exception;

public class NotFoundException extends ApiException {

    public NotFoundException(final Issue issue) {
        super(issue);
    }

    public static NotFoundException accountNotFound() {
        return new NotFoundException(new Issue(IssueType.ACCOUNT_NOT_FOUND));
    }


}
