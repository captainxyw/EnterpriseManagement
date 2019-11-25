package com.xuyewei.dao;

import com.xuyewei.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:IRoleDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/25 23:28
 * @Author:xuyewei
 */

public interface IRoleDao {
    //根据用户id查询所有的角色
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
