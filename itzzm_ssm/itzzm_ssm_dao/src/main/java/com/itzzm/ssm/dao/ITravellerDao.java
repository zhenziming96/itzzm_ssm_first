package com.itzzm.ssm.dao;


import com.itzzm.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

public interface ITravellerDao {


    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    Traveller findByOrdersId(String ordersId) throws Exception;
}
