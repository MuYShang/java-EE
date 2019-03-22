package mapper;

import pojo.Orders;

import java.util.List;

public interface OrderMapper {
    //一对一之resultType
    public List<Orders> findOrderAndUser();

    public  List<Orders> queryAll();
}
