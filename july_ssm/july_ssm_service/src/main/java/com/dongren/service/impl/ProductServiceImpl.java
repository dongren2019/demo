package com.dongren.service.impl;

import com.dongren.dao.ProductDao;
import com.dongren.domain.Product;
import com.dongren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongren
 * @create 2019-06-30 15:10
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.insert(product);
    }
}
