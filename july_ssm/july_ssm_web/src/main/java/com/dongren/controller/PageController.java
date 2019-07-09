package com.dongren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dongren
 * @create 2019-06-30 18:35
 */
@Controller
public class PageController {
    @RequestMapping("/login.do")
    public String showMain(){
        return "product_list";
    }
}
