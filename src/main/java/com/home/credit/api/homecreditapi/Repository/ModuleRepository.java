package com.home.credit.api.homecreditapi.Repository;


import com.home.credit.api.homecreditapi.Model.Domain.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

    @Query(value = "SELECT count(id) FROM module where module_name = :moduleName limit 1", nativeQuery = true)
    int findByModuleName(@Param("moduleName") String moduleName);

    @Query(value = "SELECT * FROM module where module_name = :moduleName limit 1", nativeQuery = true)
    List<Module> getByModuleName(@Param("moduleName") String moduleName);
}
