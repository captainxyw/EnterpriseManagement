package com.xuyewei.controller;

import com.xuyewei.domain.Permission;
import com.xuyewei.domain.Role;
import com.xuyewei.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ClassName:RoleController
 * Package:com.xuyewei.controller
 * Description:
 *
 * @Date:2019/11/26 22:48
 * @Author:xuyewei
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> otherPermissions = roleService.findOtherPermissions(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-permission-add");
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        return mv;
    }

    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(String roleId,  String[] ids) throws Exception {
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll.do";
    }
}
