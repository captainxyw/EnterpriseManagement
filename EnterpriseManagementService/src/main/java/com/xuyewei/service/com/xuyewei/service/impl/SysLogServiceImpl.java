package com.xuyewei.service.com.xuyewei.service.impl;

import com.xuyewei.dao.ISysLogDao;
import com.xuyewei.domain.SysLog;
import com.xuyewei.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:SysLogServiceImpl
 * Package:com.xuyewei.service.com.xuyewei.service.impl
 * Description:
 *
 * @Date:2019/11/28 22:03
 * @Author:xuyewei
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
     @Autowired
     private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
