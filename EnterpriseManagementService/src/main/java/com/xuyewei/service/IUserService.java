package com.xuyewei.service;

import com.xuyewei.domain.Role;
import com.xuyewei.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * ClassName:IUserService
 * Package:com.xuyewei.service
 * Description:
 *
 * @Date:2019/11/25 21:59
 * @Author:xuyewei
 */

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    UserInfo findById(String id) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] ids) throws Exception;
}
