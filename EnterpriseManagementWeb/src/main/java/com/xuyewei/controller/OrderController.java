package com.xuyewei.controller;

import com.github.pagehelper.PageInfo;
import com.xuyewei.domain.Orders;
import com.xuyewei.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ClassName:OrderController
 * Package:com.xuyewei.controller
 * Description:
 *
 * @Date:2019/11/24 20:12
 * @Author:xuyewei
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService ordersService;

   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-list");
        return mv;
    } */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
