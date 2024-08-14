package com.example.mini_03_shopping.orders.model;

import java.util.List;

public interface OrdersDAO {
    public int insert(OrdersVO vo);
    public int update(OrdersVO vo);
    public int delete(OrdersVO vo);
    public OrdersVO selectOne(OrdersVO vo);
    public List<OrdersVO> selectAll();
    public List<OrdersVO> searchList(String searchKey,String searchWord);
}
