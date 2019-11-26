package com.xuyewei.service.com.xuyewei.service.impl;

import com.xuyewei.dao.IRoleDao;
import com.xuyewei.domain.Role;
import com.xuyewei.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:RoleServiceImpl
 * Package:com.xuyewei.service.com.xuyewei.service.impl
 * Description:
 *
 * @Date:2019/11/26 22:50
 * @Author:xuyewei
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
}
