package com.xuyewei.dao;

import com.xuyewei.domain.Member;
import com.xuyewei.domain.Orders;
import com.xuyewei.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName:IOrdersDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/24 20:16
 * @Author:xuyewei
 */

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(id = true, property = "orderNum", column = "orderNum"),
            @Result(id = true, property = "orderTime", column = "orderTime"),
            @Result(id = true, property = "orderStatus", column = "orderStatus"),
            @Result(id = true, property = "peopleCount", column = "peopleCount"),
            @Result(id = true, property = "payType", column = "payType"),
            @Result(id = true, property = "orderDesc", column = "orderDesc"),

            @Result(id = true, property = "payType", column = "payType"),
            @Result(id = true, property = "product", column = "productId",
                    javaType = Product.class, one = @One(select = "com.xuyewei.dao.IProductDao.findById")),
    })
    public List<Orders> findAll() throws Exception;

    //多表操作
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "com.xuyewei.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "com.xuyewei.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.xuyewei.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String id) throws Exception;
}
