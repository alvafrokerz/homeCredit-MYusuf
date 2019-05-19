package com.home.credit.api.homecreditapi.Model;

public enum StatusCode {
    SUCCESS(200),
    VALIDATION_ERROR(402),
    INTERNAL_SERVER_ERROR(500),
    BAD_REQUEST(400);


    private StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }
}
