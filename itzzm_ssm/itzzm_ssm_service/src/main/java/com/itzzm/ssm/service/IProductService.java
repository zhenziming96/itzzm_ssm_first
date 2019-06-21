package com.itzzm.ssm.service;

import com.itzzm.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    //查询所有
     List<Product> findAll(int page, int size) throws Exception;

    //保存
    void save(Product product) throws Exception;


}
