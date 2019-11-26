package com.xuyewei.dao;

import com.xuyewei.domain.Role;
import org.apache.ibatis.annotations.*;

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
    @Results({
            @Result(id = true, property = "id",  column = "id"),
            @Result(property = "roleName",  column = "roleName"),
            @Result(property = "roleDesc",  column = "roleDesc"),
            @Result(property = "permissions",  javaType = java.util.List.class, column = "id",
            many = @Many(select = "com.xuyewei.dao.IPermissionDao.findPermissionByRoleId")
            )
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;
}
