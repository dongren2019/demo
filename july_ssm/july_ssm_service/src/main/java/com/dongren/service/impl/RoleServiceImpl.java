package com.dongren.service.impl;

import com.dongren.dao.RoleDao;
import com.dongren.domain.Role;
import com.dongren.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-04 17:11
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findRoleAll();
    }

    @Override
    public void addRole(Role role) throws Exception{
        roleDao.insert(role);
    }

    @Override
    public List<Role> findOtherRoleListByUserId(Integer userId) throws Exception {
        return roleDao.selectOtherRolesByUserId(userId);
    }

    @Override
    public void addPermissionsToRole(String roleId, String permissionId) throws Exception {
        roleDao.insertPermissionsToRole(roleId,permissionId);
    }
}
