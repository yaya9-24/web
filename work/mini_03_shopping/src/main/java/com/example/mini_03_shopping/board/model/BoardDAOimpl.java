package com.example.mini_03_shopping.board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO{

    private static final String DRIVER_NAME = "oracle.jdbc.OradcleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "java";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BoardDAOimpl(){
        System.out.println("BoardDAOimpl()...");
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(BoardVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into board(num,title,content,writer)" +
                    " values(seq_board.nextval,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getTitle());
            pstmt.setString(2,vo.getContent());
            pstmt.setString(3,vo.getWriter());

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
    public int update(BoardVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update board set title=?,content=?,writer=?" +
                    " where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getTitle());
            pstmt.setString(2,vo.getContent());
            pstmt.setString(3,vo.getWriter());
            pstmt.setInt(4,vo.getNum());

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
    public int delete(BoardVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from board where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

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
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        BoardVO vo2 = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "select * from board where num=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new BoardVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setTitle(rs.getString("title"));
                vo2.setContent(rs.getString("content"));
                vo2.setWriter(rs.getString("writer"));
                vo2.setWdate(rs.getDate("wdate"));
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
    public List<BoardVO> selectAll() {
        System.out.println("selectOne()...");
        List<BoardVO> list = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from board order by num desc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(rs.getDate("wdate"));
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
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println("searchKey:"+searchKey);
        System.out.println("searchWord:"+searchWord);

        List<BoardVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "";
            if (searchKey.equals("writer")){
                sql = "select * from board where writer like ? order by num desc";
            } else if (searchKey.equals("title")){
                sql = "select * from board where title like ? order by num desc";
            } else if (searchKey.equals("content")){
                sql = "select * from board where content like ? order by num desc";
            }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(rs.getDate("wdate"));
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
