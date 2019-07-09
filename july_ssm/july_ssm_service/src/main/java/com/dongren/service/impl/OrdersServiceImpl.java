package com.dongren.service.impl;

import com.dongren.dao.OrdersDao;
import com.dongren.domain.Orders;
import com.dongren.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-01 8:02
 */
@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    @Override
    public Orders findOrdersById(Integer id) throws Exception{
        return ordersDao.selectOrdersById(id);
    }
}
