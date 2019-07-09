package com.dongren.service.impl;

import com.dongren.dao.UserDao;
import com.dongren.domain.Role;
import com.dongren.domain.UserInfo;
import com.dongren.service.UserService;
import com.dongren.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 17:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE"+role.getRolename()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception{
        return userDao.findUserAll();
    }


    @Override
    public void save(UserInfo userInfo) throws Exception{
        //对密码进行加密
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        userDao.insert(userInfo);
    }

    @Override
    public UserInfo findUserDetailById(Integer id) throws Exception {
        return userDao.selectUserById(id);
    }

    @Override
    public void addRolesToUser(String userId, String roleId) throws Exception {
        userDao.insertRoleToUser(userId,roleId);
    }
}
