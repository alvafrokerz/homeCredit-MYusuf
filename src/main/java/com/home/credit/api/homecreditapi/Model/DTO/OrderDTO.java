package com.home.credit.api.homecreditapi.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class add {

        @NotNull(message = "The userId field is required")
        private String userName;

        @NotNull(message = "The moduleId field is required")
        private String moduleName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }
    }

    public static class modules {

         private String moduleName;

         private int moduleOrder;

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public int getModuleOrder() {
            return moduleOrder;
        }

        public void setModuleOrder(int moduleOrder) {
            this.moduleOrder = moduleOrder;
        }
    }
}