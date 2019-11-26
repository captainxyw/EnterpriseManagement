package com.xuyewei.service;

import com.xuyewei.domain.Permission;

import java.util.List;

/**
 * ClassName:IPermissionService
 * Package:com.xuyewei.service
 * Description:
 *
 * @Date:2019/11/26 23:09
 * @Author:xuyewei
 */

public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
