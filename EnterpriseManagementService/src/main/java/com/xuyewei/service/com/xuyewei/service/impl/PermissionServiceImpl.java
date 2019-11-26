package com.xuyewei.service.com.xuyewei.service.impl;

import com.xuyewei.dao.IPermissionDao;
import com.xuyewei.domain.Permission;
import com.xuyewei.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:PermissionService
 * Package:com.xuyewei.service.com.xuyewei.service.impl
 * Description:
 *
 * @Date:2019/11/26 23:09
 * @Author:xuyewei
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
