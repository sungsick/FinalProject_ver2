package com.kh.myproject.member.user.repository;

import com.kh.myproject.member.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {


        @Query("SELECT u FROM User u WHERE u.userId = :user_id")
    // camel case -> snake case auto change
    User findByUserId(@Param("user_id") String user_id);

    User findByUserIdAndUserPassword(@Param("user_id") String user_id,
                                     @Param("user_password") String user_password);


    @Modifying
    @Transactional
    @Query("update User u" +
            " set u.userName = :#{#user.userName} ," +
            " u.userDate = :#{#user.userDate}," +
            " u.userGender = :#{#user.userGender}," +
            " u.userPassword = :#{#user.userPassword}" +
            " where u.userNumber = :#{#user.userNumber}")
    void updateUser(@Param("user")User user);


    User findByUserNameAndUserPhone(@Param("user_name")String user_name,
                                    @Param("user_phone1")String user_phone1);


    User findByUserIdAndUserPhone(@Param("user_id")String user_id,
                                  @Param("user_phone2")String user_phone2);
}