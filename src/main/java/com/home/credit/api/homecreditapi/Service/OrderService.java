package com.home.credit.api.homecreditapi.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.credit.api.homecreditapi.Model.DTO.OrderDTO;
import com.home.credit.api.homecreditapi.Model.Domain.Module;
import com.home.credit.api.homecreditapi.Model.Domain.Orderlist;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Repository.ModuleRepository;
import com.home.credit.api.homecreditapi.Repository.OrderRepository;
import com.home.credit.api.homecreditapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private UserRepository userRepository;

    public ResultModel<Orderlist> add(OrderDTO.add input) throws JsonProcessingException {
        ResultModel<Orderlist> result = new ResultModel<>();
        result.setIsSucces(1);
//        Module module = new Module();
//        module.setModuleName("a");
//        module.setModuleOrder(1);
//        module.setOrderlist(new HashSet<>());
//        module.setId(UUID.randomUUID());
//        User user = new User();
//        user.setUsername("UserA");
//        user.setId(UUID.randomUUID());

        Orderlist orderlist = new Orderlist();
        List<User> userList = userRepository.getByUserName(input.getUserName());
        if(userList.size()==0){
            result.setIsSucces(0);
            result.setMessage("User Not Found");
            return result;
        }
        List<Module> moduleList = moduleRepository.getByModuleName(input.getModuleName());
        if(moduleList.size()==0){
            result.setIsSucces(0);
            result.setMessage("Module Not Found");
            return result;
        }
        User  user = userList.get(0);
        Module  module = moduleList.get(0);
//        module.getOrderlist().clear();

        orderlist.setUser(user);
        orderlist.setModule(module);
//        orderlist.setId(UUID.randomUUID());

        module.getOrderlist().add(orderlist);


        userRepository.save(user);
        moduleRepository.save(module);


        // test
        System.out.println("order"+module.getOrderlist().size());

        result.setData(orderlist);
        result.setMessage("Succes create data");

     return result ;
    }

    public ResultModel<List<OrderDTO.modules>> getByUserName(String input) throws JsonProcessingException {
        ResultModel<List<OrderDTO.modules>> result = new ResultModel<>();
        result.setIsSucces(1);
        final List<OrderDTO.modules> orderDtos = new ArrayList<>();


        int[] iarr = {1};
        Iterable<Orderlist> getUserName = orderRepository.findAllByOrderByIdAsc();
         getUserName.forEach(user-> {
                     ;
                      System.out.println(user.getUser().getUsername());
                     if(user.getUser().getUsername().equals(input)){
                         int moduleOrder =1;
                         OrderDTO.modules orderDto = new OrderDTO.modules();
                         orderDto.setModuleName(user.getModule().getModuleName());
                         orderDto.setModuleOrder(iarr[0]++);
                         orderDtos.add(orderDto);

                     }
         }
          );
        System.out.println(getUserName);


//        if(getUserName.size()==0){
//            result.setIsSucces(0);
//            result.setMessage("Data not found");
//            return result;
//        }
        result.setData(orderDtos);
        result.setMessage("Succes get data");

        return result ;
    }

    public ResultModel<List<OrderDTO.modules>> getByUserId(Integer input) throws JsonProcessingException {
        ResultModel<List<OrderDTO.modules>> result = new ResultModel<>();
        result.setIsSucces(1);
        final List<OrderDTO.modules> orderDtos = new ArrayList<>();


        int[] iarr = {1};
        Iterable<Orderlist> getUserName = orderRepository.findAllByOrderByIdAsc();
        getUserName.forEach(user-> {
                    ;
                    System.out.println(user.getUser().getUsername());
                    if(user.getUser().getId()==input){
                        int moduleOrder =1;
                        OrderDTO.modules orderDto = new OrderDTO.modules();
                        orderDto.setModuleName(user.getModule().getModuleName());
                        orderDto.setModuleOrder(iarr[0]++);
                        orderDtos.add(orderDto);

                    }
                }
        );
        System.out.println(getUserName);


//        if(getUserName.size()==0){
//            result.setIsSucces(0);
//            result.setMessage("Data not found");
//            return result;
//        }
        result.setData(orderDtos);
        result.setMessage("Succes get data");

        return result ;
    }
}
