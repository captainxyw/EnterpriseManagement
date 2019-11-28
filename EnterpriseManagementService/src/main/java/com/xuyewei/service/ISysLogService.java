package com.xuyewei.service;

import com.xuyewei.domain.SysLog;

import java.util.List;

/**
 * ClassName:ISysLogService
 * Package:com.xuyewei.service
 * Description:
 *
 * @Date:2019/11/28 22:03
 * @Author:xuyewei
 */

public interface ISysLogService {
    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
