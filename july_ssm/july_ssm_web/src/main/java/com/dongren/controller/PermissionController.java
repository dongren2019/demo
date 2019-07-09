package com.dongren.controller;

import com.dongren.domain.Permission;
import com.dongren.domain.Role;
import com.dongren.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-04 18:54
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/show_permissionList_page")
    public String showPermissionListPage(){
        return "permission_list";
    }

    @RequestMapping(value = "/find_all",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo findAll(@RequestParam(value = "pageNum",defaultValue = "1",required = true)Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "2",required = true)Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> list = null;
        try {
            list = permissionService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @RequestMapping(value = "/show_addPermission_page")
    public String showAddPermissionPage(){
        return "permission_add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String addPermission(Permission permission){
        String s = "";
        try {
            permissionService.addRole(permission);
            s = "redirect:/permission/show_permissionList_page";
        } catch (Exception e) {
            s= "";
            e.printStackTrace();
        }
        return s;
    }

    @RequestMapping(value = "/getOtherPermissionListByRoleId",method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getOtherPermissionListByRoleId(Integer roleId){
        List<Permission> otherPermissionList = null;
        try {
            otherPermissionList = permissionService.findOtherPermissionListByRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otherPermissionList;
    }
}
