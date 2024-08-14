package com.example.mini_03_shopping.product.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDAO{

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ProductDAOimpl(){
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(ProductVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into product(num,pname,price,img) " +
                    " values(seq_product.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getPname());
            pstmt.setInt(2,vo.getPrice());
            pstmt.setString(3,vo.getImgName());

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
            }
            if (conn!=null) {
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
    public int update(ProductVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update product set pname=?,price=?,img=? where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getPname());
            pstmt.setInt(2,vo.getPrice());
            pstmt.setString(3,vo.getImgName());
            pstmt.setInt(4,vo.getNum());

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
            }
            if (conn!=null) {
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
    public int delete(ProductVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from product where num=?";
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
            }
            if (conn!=null) {
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
    public ProductVO selectOne(ProductVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        ProductVO vo2 = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from product where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new ProductVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setPname(rs.getString("pname"));
                vo2.setPrice(rs.getInt("price"));
                vo2.setImgName(rs.getString("img"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null) {
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
    public List<ProductVO> selectAll() {
        System.out.println("selectAll()...");
        List<ProductVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from product order by num desc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setPrice(rs.getInt("price"));
                vo.setImgName(rs.getString("img"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null) {
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
    public List<ProductVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println("searchKey:"+searchKey);
        System.out.println("searchWord:"+searchWord);
        List<ProductVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");
            String sql ="";
            if (searchKey.equals("pname")){
                sql = "select * from product where pname like ? order by num desc";
            } else if (searchKey.equals("user_id")) {
                sql = "select * from product where user_id like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNum(rs.getInt("num"));
                vo.setPname(rs.getString("pname"));
                vo.setPrice(rs.getInt("price"));
                vo.setImgName(rs.getString("img"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn!=null) {
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
