package com.home.credit.api.homecreditapi.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class  add{

        @NotNull(message = "The moduleName field is required")
        private String moduleName;


        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }


    }
}
