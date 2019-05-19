package com.home.credit.api.homecreditapi.Controller;

import com.home.credit.api.homecreditapi.Model.DTO.OrderDTO;
import com.home.credit.api.homecreditapi.Model.Domain.Orderlist;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/order")
public class OrderController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;



    @PostMapping(path="/add")
    public ResponseEntity<ResultModel> newProduct(@Valid @RequestBody OrderDTO.add request) {
        ResultModel<Orderlist> result = new ResultModel<>();

         try {
            result = orderService.add(request);

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

    @GetMapping(path="/getByUserName")
    public ResponseEntity<HashMap<String, List<OrderDTO.modules>> > getByName(@RequestParam(name = "userName") String request) {
        ResultModel<List<OrderDTO.modules>> result = new ResultModel<>();

        HashMap<String, List<OrderDTO.modules>> body = new HashMap<>();
        try {
            result = orderService.getByUserName(request);
            body.put("modules",result.getData());

            if(result.getIsSucces()==0){
                result.setIsSucces(null);
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                        .header("Message", result.getMessage())
                        .body(null);
            }
            result.setIsSucces(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setData(null);
            result.setMessage("INTERNAL SERVER ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Message", "INTERNAL SERVER ERROR")
                    .body(null );

        }


        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", result.getMessage())
                .body(body);
    }

    @GetMapping(path="/getByUserId")
    public ResponseEntity<HashMap<String, List<OrderDTO.modules>> > getByUserId(@RequestParam(name = "UserID") Integer request) {
        ResultModel<List<OrderDTO.modules>> result = new ResultModel<>();

        HashMap<String, List<OrderDTO.modules>> body = new HashMap<>();
        try {
            result = orderService.getByUserId(request);
            body.put("modules",result.getData());

            if(result.getIsSucces()==0){
                result.setIsSucces(null);
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
                        .header("Message", result.getMessage())
                        .body(null);
            }
            result.setIsSucces(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setData(null);
            result.setMessage("INTERNAL SERVER ERROR");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Message", "INTERNAL SERVER ERROR")
                    .body(null );

        }


        return ResponseEntity.status(HttpStatus.OK)
                .header("Message", result.getMessage())
                .body(body);
    }
}
