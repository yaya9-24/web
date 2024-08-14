package com.example.mini_03_shopping.reviews.model;

import java.util.List;

public interface ReviewsDAO {
    public int insert(ReviewsVO vo);
    public int update(ReviewsVO vo);
    public int delete(ReviewsVO vo);
    public ReviewsVO selectOne(ReviewsVO vo);
    public List<ReviewsVO> selectAll();
    public List<ReviewsVO> searchList(String searchKey,String searchWord);
}
