package com.dongren.controller;

import com.dongren.domain.Orders;
import com.dongren.service.OrdersService;
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
 * @create 2019-07-01 8:02
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/show_ordersList_page")
    public String showListPage(){
        return "orders_list";
    }

    @RequestMapping(value = "/find_all",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo findAll(@RequestParam(value = "pageSize", required = true, defaultValue = "2")Integer pageSize, @RequestParam(value = "pageNum", required = true, defaultValue = "1")Integer pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> list = null;
        try {
            list = ordersService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @RequestMapping("/showOrdersDetailPage")
    public String showOrderDetailPage(){
        return "orders_detail";
    }

    @RequestMapping("/findOrdersById")
    @ResponseBody
    public Orders getOrdersById(Integer id){
        Orders orders = null;
        try {
            orders = ordersService.findOrdersById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
