package com.xuyewei.controller;

import com.xuyewei.domain.Role;
import com.xuyewei.domain.UserInfo;
import com.xuyewei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PreAuthorize("hasRole(\"ROLE_ADMIN\")")
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
    @PreAuthorize("authentication.principal.username=='tom'")
    public String save(UserInfo userInfo) throws Exception {
        userService.save (userInfo);
        return "redirect:findAll.do";
    }
    //用户可以添加的角色
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView mv=  new ModelAndView();
        UserInfo user = userService.findById(id);
        List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user", user);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="ids", required = true) String[] ids,
                              @RequestParam(name="userId", required = true) String userId) throws Exception {
        userService.addRoleToUser(userId, ids);

        return "redirect:findAll.do";
    }
}
