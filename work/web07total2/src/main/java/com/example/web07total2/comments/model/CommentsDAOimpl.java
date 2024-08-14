package com.example.web07total2.comments.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAOimpl implements CommentsDAO{

    private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER ="java";
    private static final String PASSWORD ="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public CommentsDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(CommentsVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag =0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into comments(num,content,writer,bnum) " +
                    "values(seq_comments.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getContent());
            pstmt.setString(2,vo.getWriter());
            pstmt.setInt(3,vo.getBnum());

            flag = pstmt.executeUpdate(); //DML
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
    public int update(CommentsVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag =0;
        try {
            conn =DriverManager.getConnection(URL,USER,PASSWORD);

            String sql ="update comments set content=?,wdate=sysdate where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getContent());
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
    public int delete(CommentsVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag =0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql ="delete from comments where num=?";
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
    public CommentsVO selectOne(CommentsVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        CommentsVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from comments where num=? order by num desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new CommentsVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setContent(rs.getString("content"));
                vo2.setWriter(rs.getString("writer"));
                vo2.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
                vo2.setBnum(rs.getInt("bnum"));

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
    public List<CommentsVO> selectAll(int bnum) {
        System.out.println("selectAll()...bnum:"+bnum);
        List<CommentsVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from comments where bnum=? order by num desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,bnum);

            rs = pstmt.executeQuery();
            while (rs.next()){
                CommentsVO vo = new CommentsVO();
                vo.setNum(rs.getInt("num"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
                vo.setBnum(rs.getInt("bnum"));
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
    public List<CommentsVO> searchList(String searchKey, String searchWord, int bnum) {
        System.out.println("searchList()...bnum:"+bnum);
        System.out.println("searchList()...searchKey:"+searchKey);
        System.out.println("searchList()...searchWord:"+searchWord);
        List<CommentsVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "";
            if (searchKey.equals("content")){
                sql = "select * from comments where bnum=? and content like ? order by num desc";
            }else {
                sql = "select * from comments where bnum=? and writer like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,bnum);
            pstmt.setString(2,"%"+searchWord+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                CommentsVO vo = new CommentsVO();
                vo.setNum(rs.getInt("num"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(new Timestamp(rs.getTimestamp("wdate").getTime()).toString());
                vo.setBnum(rs.getInt("bnum"));
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
