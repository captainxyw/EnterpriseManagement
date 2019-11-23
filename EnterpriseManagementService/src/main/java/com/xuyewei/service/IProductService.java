package com.xuyewei.service;

import com.xuyewei.domain.Product;

import java.util.List;

/**
 * ClassName:IProductService
 * Package:com.xuyewei
 * Description:
 *
 * @Date:2019/11/21 23:42
 * @Author:xuyewei
 */

public interface IProductService {
    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
