package com.home.credit.api.homecreditapi.Repository;


import com.home.credit.api.homecreditapi.Model.Domain.Orderlist;
import com.home.credit.api.homecreditapi.Model.Domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orderlist, Integer> {

   @Query(value = "SELECT  * FROM `orderlist` o where o.username=:userName ", nativeQuery = true)
    List<Orderlist> getByUserName(@Param("userName") String userName);

    public List<Orderlist> findAllByOrderByIdAsc();
}
