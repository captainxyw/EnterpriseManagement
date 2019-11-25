package com.xuyewei.dao;

import com.xuyewei.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:IUserDao
 * Package:com.xuyewei.domain
 * Description:
 *
 * @Date:2019/11/25 22:09
 * @Author:xuyewei
 */

public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            //@Result(property = "statusStr", column = "statusStr"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select="com.xuyewei.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;
}
