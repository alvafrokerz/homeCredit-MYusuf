package com.home.credit.api.homecreditapi.Exception;


import com.home.credit.api.homecreditapi.Model.StatusCode;


import java.util.Map;
import java.util.Set;

public class ErrorDetails {

    private String message;
    private Map<String, Set<String>> validations;


    public ErrorDetails( String message, Map<String, Set<String>> validations) {
        super();

        this.message = message;
        this.validations = validations;
    }
    public ErrorDetails( String message ) {
        super();

        this.message = message;

    }


    public String getMessage() {
        return message;
    }

    public Map<String, Set<String>> getValidations() {
        return validations;
    }

    public void setValidations(Map<String, Set<String>> validations) {
        this.validations = validations;
    }
}
