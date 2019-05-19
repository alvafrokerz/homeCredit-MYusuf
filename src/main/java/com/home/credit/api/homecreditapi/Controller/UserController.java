package com.home.credit.api.homecreditapi.Controller;

import com.home.credit.api.homecreditapi.Model.DTO.ModuleDTO;
import com.home.credit.api.homecreditapi.Model.DTO.UserDTO;
import com.home.credit.api.homecreditapi.Model.Domain.Module;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Service.ModuleService;
import com.home.credit.api.homecreditapi.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/user")
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    Map<String,String> bodyResponse;

    @PostMapping(path="/add")
    public ResponseEntity<ResultModel> add(@Valid @RequestBody UserDTO.add request) {
        ResultModel<User> result = new ResultModel<>();

        bodyResponse = new HashMap<>();
        try {
            result = userService.add(request);

            if(result.getIsSucces()==0){
                result.setIsSucces(null);
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                        .header("Message", result.getMessage())
                        .body(result);
            }
            result.setIsSucces(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setData(null);
            result.setMessage("INTERNAL SERVER ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Message", "INTERNAL SERVER ERROR")
                    .body(result );

        }


        return ResponseEntity.status(HttpStatus.OK)
            .header("Message", result.getMessage())
                .body(result);
}

    @GetMapping(path="/getByName")
    public ResponseEntity<ResultModel> getByName(@RequestParam(name = "userName") String request) {
        ResultModel<List<User>> result = new ResultModel<>();

        bodyResponse = new HashMap<>();
        try {
             result = userService.getByName(request);

            if(result.getIsSucces()==0){
                result.setIsSucces(null);
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                        .header("Message", result.getMessage())
                        .body(result);
            }
            result.setIsSucces(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setData(null);
            result.setMessage("INTERNAL SERVER ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Message", "INTERNAL SERVER ERROR")
                    .body(result );

        }


        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", result.getMessage())
                .body(result);
    }


}
