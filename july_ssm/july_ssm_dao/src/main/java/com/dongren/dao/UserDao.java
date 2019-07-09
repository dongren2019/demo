package com.dongren.dao;

import com.dongren.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 15:32
 */
public interface UserDao {

    List<UserInfo> findUserAll();

    UserInfo findByUsername(String username);

    void insert(UserInfo userInfo);

    UserInfo selectUserById(Integer id);

    void insertRoleToUser(@Param(value = "userId") String userId, @Param(value = "roleId")String roleId);
}
