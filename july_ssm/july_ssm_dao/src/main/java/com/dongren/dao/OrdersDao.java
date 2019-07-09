package com.dongren.dao;

import com.dongren.domain.Orders;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-01 8:03
 */
public interface OrdersDao {
    List<Orders> findAll();

    Orders selectOrdersById(Integer id);
}
