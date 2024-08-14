package com.example.mini_03_shopping.cart.model;

import java.util.List;

public interface CartDAO {
    public int insert(CartVO vo);
    public int update(CartVO vo);
    public int delete(CartVO vo);
    public CartVO selectOne(CartVO vo);
    public List<CartVO> selectAll();
    public List<CartVO> searchList(String searchKey,String searchWord);
}
