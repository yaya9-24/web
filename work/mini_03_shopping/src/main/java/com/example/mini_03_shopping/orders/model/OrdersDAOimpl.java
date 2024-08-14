package com.example.mini_03_shopping.orders.model;

import java.sql.*;
import java.util.List;

public class OrdersDAOimpl implements OrdersDAO{
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public OrdersDAOimpl(){
        System.out.println("OrdersDAOimpl()...");
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(OrdersVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into orders(num,pname,sum,user_id,pnum)" +
                    " values(seq_orders.nextval,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getPname());
            pstmt.setInt(2,vo.getSum());
            pstmt.setString(3,vo.getUser_id());
            pstmt.setInt(4,vo.getPnum());

            flag = pstmt.executeUpdate();
            System.out.println("flag:"+flag);
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
    public int update(OrdersVO vo) {
        return 0;
    }

    @Override
    public int delete(OrdersVO vo) {
        return 0;
    }

    @Override
    public OrdersVO selectOne(OrdersVO vo) {
        return null;
    }

    @Override
    public List<OrdersVO> selectAll() {
        return null;
    }

    @Override
    public List<OrdersVO> searchList(String searchKey, String searchWord) {
        return null;
    }
}
