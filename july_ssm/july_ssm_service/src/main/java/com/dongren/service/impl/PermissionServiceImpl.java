package com.dongren.service.impl;

import com.dongren.dao.PermissionDao;
import com.dongren.domain.Permission;
import com.dongren.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-04 18:58
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findPermissionAll();
    }

    @Override
    public void addRole(Permission permission) throws Exception {
        permissionDao.insert(permission);
    }

    @Override
    public List<Permission> findOtherPermissionListByRoleId(Integer roleId) throws Exception {
        return permissionDao.selectOtherPermissionsByRoleId(roleId);
    }
}
