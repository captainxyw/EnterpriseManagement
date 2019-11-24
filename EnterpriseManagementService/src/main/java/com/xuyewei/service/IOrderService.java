package com.xuyewei.service;

import com.xuyewei.domain.Orders;

import java.util.List;

/**
 * ClassName:IOrderService
 * Package:com.xuyewei.service
 * Description:
 *
 * @Date:2019/11/24 20:12
 * @Author:xuyewei
 */

public interface IOrderService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String id) throws Exception;
}
