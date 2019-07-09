package com.dongren.service;

import com.dongren.domain.Role;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-04 17:11
 */
public interface RoleService {

    List<Role> findAll() throws Exception;

    void addRole(Role role) throws Exception;

    List<Role> findOtherRoleListByUserId(Integer userId) throws Exception;

    void addPermissionsToRole(String roleId, String permissionId) throws Exception;
}
