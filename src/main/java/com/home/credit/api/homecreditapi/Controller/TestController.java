package com.home.credit.api.homecreditapi.Controller;

import com.home.credit.api.homecreditapi.Model.Domain.Test;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Model.StatusCode;
import com.home.credit.api.homecreditapi.Service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.ValidationException;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class TestController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;


    @GetMapping(path="/test")
    public ResponseEntity<ResultModel> newProduct() {
        ResultModel<Iterable<Test>> result = new ResultModel<>();
        try {
            result = testService.test();
            if(result.getIsSucces()==0){
                result.setIsSucces(null);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .header("Message", result.getMessage())
                        .body(result);
            }
            result.setIsSucces(null);
        } catch (Exception ex) {
            result.setMessage("INTERNAL SERVER ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Message", "INTERNAL SERVER ERROR")
                    .body(result );

        }
        result.setData(null);
        result.setMessage("INTERNAL SERVER ERROR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Message", "INTERNAL SERVER ERROR")
                .body(result );
    }
}
