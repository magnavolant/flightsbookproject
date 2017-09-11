package com.flights.user.repository;

import com.flights.user.pojo.UserAdditionalInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserAdditionalInfoRepository extends CrudRepository<UserAdditionalInfo, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE UserAdditionalInfo i set i.userId = ?1, i.name =?2, i.surname=?3")
    void setUserInfoByUserId(int userID, String name, String surname);

    @Query("SELECT i FROM UserAdditionalInfo i where i.userId = :id")
    UserAdditionalInfo getUserAdditionalInfoByUserId(@Param("id") int userId);

}
