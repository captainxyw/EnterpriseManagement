package com.xuyewei.controller;

import com.xuyewei.domain.UserInfo;
import com.xuyewei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ClassName:UserController
 * Package:com.xuyewei.controller
 * Description:
 *
 * @Date:2019/11/26 20:36
 * @Author:xuyewei
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save (userInfo);
        return "redirect:findAll.do";
    }
}
