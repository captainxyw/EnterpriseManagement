package com.xuyewei.controller;

import com.xuyewei.domain.SysLog;
import com.xuyewei.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * ClassName:LogController
 * Package:com.xuyewei.controller
 * Description:
 *
 * @Date:2019/11/28 22:25
 * @Author:xuyewei
 */
@Controller
@RequestMapping("/sysLog")
public class LogController {
    @Autowired
    private ISysLogService syslogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList =  syslogService.findAll();
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
