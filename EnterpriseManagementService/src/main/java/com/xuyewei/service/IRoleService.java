package com.xuyewei.service;

import com.xuyewei.domain.Role;

import java.util.List;

/**
 * ClassName:IRoleService
 * Package:com.xuyewei.service
 * Description:
 *
 * @Date:2019/11/26 22:49
 * @Author:xuyewei
 */

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;
}
