package com.hwl.mybatis.mapper;

import com.hwl.mybatis.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> queryAll();
    List<Order> queryAll1();
}
