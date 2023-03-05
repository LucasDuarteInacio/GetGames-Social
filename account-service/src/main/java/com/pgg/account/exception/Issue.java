package com.pgg.account.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    @JsonProperty private String code;

    @JsonProperty private String message;

    @JsonProperty private List<String> details;

    public Issue(final IssueType issue) {
        code = issue.getCode();
        message = issue.getFormattedMessage();
    }

    public Issue(final IssueType issue, final List<String> details) {
        this(issue);
        this.details = details;
    }

    @Override
    public String toString() {
        return String.format("Issue{code= %s, message='%s' details= '%s'}", code, message, details);
    }
}
