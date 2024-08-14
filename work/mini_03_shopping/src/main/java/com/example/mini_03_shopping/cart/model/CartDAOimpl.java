package com.example.mini_03_shopping.cart.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOimpl implements CartDAO{
    private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER ="java";
    private static final String PASSWORD ="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public CartDAOimpl(){
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(CartVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into cart(num,pname,price,count,cart_id)" +
                    " values(?,?,?,?,seq_cart.nextval)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());
            pstmt.setString(2,vo.getPname());
            pstmt.setInt(3,vo.getPrice());
            pstmt.setInt(4,vo.getCount());

            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
        return flag;
    }

    @Override
    public int update(CartVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update cart set price=?,count=? where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getPrice());
            pstmt.setInt(2,vo.getCount());
            pstmt.setInt(3,vo.getNum());

            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
        return flag;
    }

    @Override
    public int delete(CartVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from cart where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
        return flag;
    }

    @Override
    public CartVO selectOne(CartVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);

        CartVO vo2 = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = "select * from cart where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new CartVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setPname(rs.getString("pname"));
                vo2.setPrice(rs.getInt("price"));
                vo2.setCount(rs.getInt("count"));
                vo2.setCart_id(rs.getInt("cart_id"));
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
    public List<CartVO> selectAll() {
        System.out.println("selectOne()...");
        List<CartVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = "select * from cart order by cart_id desc";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                CartVO vo = new CartVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setPrice(rs.getInt("price"));
                vo.setCount(rs.getInt("count"));
                vo.setCart_id(rs.getInt("cart_id"));
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
    public List<CartVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        List<CartVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = "select * from cart order by cart_id desc";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                CartVO vo = new CartVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setPrice(rs.getInt("price"));
                vo.setCount(rs.getInt("count"));
                vo.setCart_id(rs.getInt("cart_id"));
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
