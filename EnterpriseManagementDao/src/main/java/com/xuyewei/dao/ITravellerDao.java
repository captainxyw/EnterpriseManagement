package com.xuyewei.dao;

import com.xuyewei.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:ITravellerDao
 * Package:com.xuyewei.dao
 * Description:
 *
 * @Date:2019/11/24 22:41
 * @Author:xuyewei
 */

public interface ITravellerDao {
    @Select(
            "select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})"
    )
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
