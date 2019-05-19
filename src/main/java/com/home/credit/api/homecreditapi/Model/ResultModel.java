package com.home.credit.api.homecreditapi.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpHeaders;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultModel<T> {

    private T data;

    private String message;

    private Integer isSucces;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIsSucces() {
        return isSucces;
    }

    public void setIsSucces(Integer isSucces) {
        this.isSucces = isSucces;
    }
}
