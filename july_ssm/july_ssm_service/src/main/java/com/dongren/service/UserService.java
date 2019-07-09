package com.dongren.service;

import com.dongren.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 17:01
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findUserDetailById(Integer id) throws Exception;

    void addRolesToUser(String userId, String roleId) throws Exception;
}
