package com.dongren.dao;

import com.dongren.domain.Product;

import java.util.List;

/**
 * @author dongren
 * @create 2019-06-30 15:08
 */
public interface ProductDao {
    List<Product> findAll() throws Exception;

    void insert(Product product) throws Exception;

    Product findById(Integer id) throws Exception;
}
