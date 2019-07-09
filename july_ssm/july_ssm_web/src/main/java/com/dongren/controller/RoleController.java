package com.dongren.controller;

import com.dongren.dao.RoleDao;
import com.dongren.domain.Role;
import com.dongren.domain.UserInfo;
import com.dongren.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dongren
 * @create 2019-07-04 15:04
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/show_roleList_page")
    public String showRoleListPage(){
        return "role_list";
    }

    @RequestMapping(value = "/find_all",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo findAll(@RequestParam(value = "pageNum",defaultValue = "1",required = true)Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "2",required = true)Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Role> list = null;
        try {
            list = roleService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @RequestMapping(value = "/show_roleAdd_page")
    public String showRoleAddPage(){
        return "role_add";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String addRole(Role role){
        String s = "";
        try {
            roleService.addRole(role);
            s = "redirect:/role/show_roleList_page";
        } catch (Exception e) {
            s= "";
            e.printStackTrace();
        }
        return s;
    }


    @RequestMapping(value = "/getOtherRoleListByUserId",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getOtherRoleListByUserId(Integer userId){
        List<Role> otherRoleList = null;
        try {
            otherRoleList = roleService.findOtherRoleListByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otherRoleList;
    }

    @RequestMapping(value = "/show_addPermissionsToRole_page")
    public String showOtherRoleListPage(){
        return "otherPermission_list";
    }

    @RequestMapping(value = "/addPermissionsToRole",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addPermissionsToRole(String roleId,String ids){
        Map<String,String> map = new HashMap<>();
        if(ids != null&& !"".equals(ids)){
            try {
                if(ids.contains("-")){
                    String[] idArray = ids.split("-");
                    for(String id:idArray){
                        roleService.addPermissionsToRole(roleId,id);
                    }
                    map.put("flag","true");
                }else{
                    roleService.addPermissionsToRole(roleId,ids);
                    map.put("flag","true");
                }
            } catch (Exception e) {
                map.put("flag","false");
                e.printStackTrace();
            }
        }else{
            map.put("flag","false");
        }
        return map;
    }
}
