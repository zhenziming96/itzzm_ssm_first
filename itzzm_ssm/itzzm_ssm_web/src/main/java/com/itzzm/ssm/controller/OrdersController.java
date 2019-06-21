package com.itzzm.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itzzm.ssm.domain.Orders;
import com.itzzm.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;


    //分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page,size);
         ModelAndView mv = new ModelAndView();
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById( @RequestParam(name = "id", required = true) String ordersId) throws Exception{
        Orders orders = ordersService.findById(ordersId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
