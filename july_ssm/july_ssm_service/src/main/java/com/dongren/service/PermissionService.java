package com.dongren.service;

import com.dongren.domain.Permission;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-04 18:57
 */
public interface PermissionService {

    List<Permission> findAll() throws Exception;

    void addRole(Permission permission) throws Exception;

    List<Permission> findOtherPermissionListByRoleId(Integer roleId) throws Exception;
}
