package com.home.credit.api.homecreditapi.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class  add{

        @NotNull(message = "The userName field is required")
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
