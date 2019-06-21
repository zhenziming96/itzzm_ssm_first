package com.itzzm.ssm.dao;

import com.itzzm.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductDao {

    //查询所有的产品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    //通过id查询产品信息
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

    //添加商品信息
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;


}
