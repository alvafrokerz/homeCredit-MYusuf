package com.home.credit.api.homecreditapi.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.credit.api.homecreditapi.Model.DTO.ModuleDTO;
import com.home.credit.api.homecreditapi.Model.Domain.Module;
import com.home.credit.api.homecreditapi.Model.ResultModel;
import com.home.credit.api.homecreditapi.Repository.ModuleRepository;
import com.home.credit.api.homecreditapi.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public ResultModel<Module> add(ModuleDTO.add input) throws JsonProcessingException {
        ResultModel<Module> result = new ResultModel<>();
        result.setIsSucces(1);
        int findModuleName = moduleRepository.findByModuleName(input.getModuleName());
        if(findModuleName!=0){
            result.setIsSucces(0);
            result.setMessage("Module Name is duplicate");
            return result;
        }
        Module module = new Module();
//        module.setId(UUID.randomUUID());
        module.setModuleName(input.getModuleName());

        moduleRepository.save(module);

        result.setData(module);
        result.setMessage("Succes create data");

     return result ;
    }

    public ResultModel<List<Module>> getByName(String input) throws JsonProcessingException {
        ResultModel<List<Module>> result = new ResultModel<>();
        result.setIsSucces(1);

        List<Module> getModuleName = moduleRepository.getByModuleName(input);
        if(getModuleName.size()==0){
            result.setIsSucces(0);
            result.setMessage("Data not found");
            return result;
        }
        result.setData(getModuleName);
        result.setMessage("Succes get data");

        return result ;
    }
}
