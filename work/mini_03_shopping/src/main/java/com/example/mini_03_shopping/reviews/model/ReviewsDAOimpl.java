package com.example.mini_03_shopping.reviews.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewsDAOimpl implements ReviewsDAO{
    private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER ="java";
    private static final String PASSWORD ="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ReviewsDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(ReviewsVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into reviews(num,content,writer,bnum) " +
                    " values(seq_reviews.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getContent());
            pstmt.setString(2,vo.getWriter());
            pstmt.setInt(3,vo.getBnum());

            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public int update(ReviewsVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update reviews set content=? wdate=sysdate where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getContent());
            pstmt.setInt(2,vo.getNum());

            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public int delete(ReviewsVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from reviews where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public ReviewsVO selectOne(ReviewsVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        ReviewsVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from reviews where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new ReviewsVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setContent(rs.getString("content"));
                vo2.setWriter(rs.getString("writer"));
                vo2.setWdate(rs.getDate("wdate"));
                vo2.setBnum(rs.getInt("bnum"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return vo2;
    }

    @Override
    public List<ReviewsVO> selectAll() {
        System.out.println("selectAll()...");
        List<ReviewsVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from reviews order by num desc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                ReviewsVO vo = new ReviewsVO();
                vo.setNum(rs.getInt("num"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(rs.getDate("wdate"));
                vo.setBnum(rs.getInt("bnum"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    @Override
    public List<ReviewsVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println("searchKey:"+searchKey);
        System.out.println("searchWord:"+searchWord);
        List<ReviewsVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "";
            if (searchKey.equals("content")){
                sql = "select * from reviews where content like ? order by num desc";
            } else if (searchKey.equals("writer")){
                sql = "select * from reviews where writer like ? order by num desc";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");
            rs = pstmt.executeQuery();
            while (rs.next()){
                ReviewsVO vo = new ReviewsVO();
                vo.setNum(rs.getInt("num"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(rs.getDate("wdate"));
                vo.setBnum(rs.getInt("bnum"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
}
