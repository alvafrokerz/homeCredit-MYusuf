package com.home.credit.api.homecreditapi.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.credit.api.homecreditapi.Model.DTO.UserDTO;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResultModel<User> add(UserDTO.add input) throws JsonProcessingException {
        ResultModel<User> result = new ResultModel<>();
        result.setIsSucces(1);
        int findUserName = userRepository.findByUserName(input.getUserName());
        if(findUserName!=0){
            result.setIsSucces(0);
            result.setMessage("Username is duplicate");
            return result;
        }

        User user = new User();
//        user.setId(UUID.randomUUID());
        user.setUsername(input.getUserName());

        userRepository.save(user);

        result.setData(user);
        result.setMessage("Succes create data");

     return result ;
    }

    public ResultModel<List<User>> getByName(String input) throws JsonProcessingException {
        ResultModel<List<User>> result = new ResultModel<>();
        result.setIsSucces(1);
        List<User> getUserName = userRepository.getByUserName(input);
        if(getUserName.size()==0){
            result.setIsSucces(0);
            result.setMessage("Data not found");
            return result;
        }
        result.setData(getUserName);
        result.setMessage("Succes get data");

        return result ;
    }
}
