package com.dongren.service;

import com.dongren.domain.Product;

import java.util.List;

/**
 * @author dongren
 * @create 2019-06-30 15:09
 */
public interface ProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
