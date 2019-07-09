package com.dongren.service;

import com.dongren.domain.Orders;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-01 8:02
 */
public interface OrdersService {
    List<Orders> findAll() throws Exception;

    Orders findOrdersById(Integer id) throws Exception;
}
