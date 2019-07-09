package com.dongren.controller;

import com.dongren.domain.UserInfo;
import com.dongren.service.UserService;
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
 * @create 2019-07-04 9:48
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show_userList_page")
    public String showUserListPage(){
        return "user_list";
    }

    @RequestMapping(value = "/find_all",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo findAll(@RequestParam(value = "pageNum",defaultValue = "1",required = true)Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "2",required = true)Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list = null;
        try {
            list = userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @RequestMapping(value = "/user_add_page")
    public String showAddPage(){
        return "user_add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addUser(UserInfo userInfo){
        Map<String,String> map = new HashMap<>();
        try {
            userService.save(userInfo);
            map.put("flag","true");
        } catch (Exception e) {
            map.put("flag","false");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "/show_userDeatil_page")
    public String showUserDetailPage(){
        return "user_detail";
    }

    @RequestMapping(value = "/findUserDetail",method = RequestMethod.POST)
    @ResponseBody
    public UserInfo getUserDetailById(Integer id){
        UserInfo userInfo = null;
        try {
            userInfo = userService.findUserDetailById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @RequestMapping(value = "/show_otherRoleList_page")
    public String showOtherRoleListPage(){
        return "otherRole_list";
    }

    @RequestMapping(value = "/addRolesToUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addRolesToUser(String userId,String ids){
        Map<String,String> map = new HashMap<>();
        if(ids != null&& !"".equals(ids)){
            try {
                if(ids.contains("-")){
                    String[] idArray = ids.split("-");
                    for(String id:idArray){
                        userService.addRolesToUser(userId,id);
                    }
                    map.put("flag","true");
                }else{
                    userService.addRolesToUser(userId,ids);
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
