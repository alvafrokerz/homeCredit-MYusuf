package com.home.credit.api.homecreditapi.Repository;


import com.home.credit.api.homecreditapi.Model.Domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT  count(id) FROM `user` where username = :userName   limit 1", nativeQuery = true)
    int findByUserName(@Param("userName") String userName);

    @Query(value = "SELECT  * FROM `user` where username = :userName   limit 1", nativeQuery = true)
    List<User> getByUserName(@Param("userName") String userName);

    @Query(value = "SELECT  * FROM `user` u  where username = :userName ", nativeQuery = true)
    List<User> getByUserNameLeftJoinOrderList(@Param("userName") String userName);
}
