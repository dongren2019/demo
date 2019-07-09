package com.dongren.dao;

import com.dongren.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 15:32
 */
public interface RoleDao {
    List<Role> findRoleAll();

    List<Role> selectRoleListByUserId(Integer id);


    void insert(Role role);

    List<Role> selectOtherRolesByUserId(Integer userId);

    void insertPermissionsToRole(@Param(value = "roleId") String roleId, @Param(value = "permissionId")String permissionId);
}
