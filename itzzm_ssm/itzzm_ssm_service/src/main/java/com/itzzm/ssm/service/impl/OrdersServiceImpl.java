package com.itzzm.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.itzzm.ssm.dao.IOrdersDao;
import com.itzzm.ssm.domain.Orders;
import com.itzzm.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao orderDao;

    @Override
    public List<Orders> findAll(int page,int size) throws Exception {

        //参数page是页码值   参数Size 代表是每页显示条数
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }
}
