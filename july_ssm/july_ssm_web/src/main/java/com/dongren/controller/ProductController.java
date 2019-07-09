package com.dongren.controller;

import com.dongren.domain.Product;
import com.dongren.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dongren
 * @create 2019-06-30 15:31
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/show_productList_page")
    public String showListPage(){
        return "product_list";
    }

    @RequestMapping(value = "/product_add_page")
    public String showAddPage(){
        return "product_add";
    }

    @RequestMapping(value="/find_all",method = RequestMethod.POST)
    @ResponseBody
    public List<Product> findAll(){
        List<Product> list = null;
        try {
             list = productService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(Product product, HttpServletResponse response){
        Map<String,String> map = new HashMap();
        try {
            productService.save(product);
            map.put("flag","true");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag","false");
        }
        return map;

    }
}
