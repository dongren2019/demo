package com.dongren.dao;

import com.dongren.domain.Permission;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 15:32
 */
public interface PermissionDao {
    List<Permission> findPermissionAll();

    List<Permission> selectPermissionListByRoleId(Integer roleId);

    void insert(Permission permission);

    List<Permission> selectOtherPermissionsByRoleId(Integer roleId);
}
