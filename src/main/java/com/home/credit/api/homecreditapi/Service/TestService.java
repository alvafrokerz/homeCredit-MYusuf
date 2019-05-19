package com.home.credit.api.homecreditapi.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.credit.api.homecreditapi.Model.Domain.Test;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public ResultModel <Iterable<Test>> test() throws JsonProcessingException {
        ResultModel<Iterable<Test>> result = new ResultModel<>();
        Iterable<Test> testList = testRepository.findAll();
        result.setData(testList);
        result.setMessage("Create Data Succes");
        return result ;
    }

}
