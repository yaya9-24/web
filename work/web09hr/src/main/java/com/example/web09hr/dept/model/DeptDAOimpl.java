package com.example.web09hr.dept.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDAOimpl implements DeptDAO{

    private static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
    private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER="hr";
    private static final String PASSWORD="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public DeptDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(DeptVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into dept(department_id,department_name,manager_id,location_id)"+
                    "values(departments_seq.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getDepartment_name());
            pstmt.setInt(2,vo.getManager_id());
            pstmt.setInt(3,vo.getLocation_id());


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
    public int update(DeptVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update dept set department_name=?,manager_id=?,location_id " +
                    " where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getDepartment_name());
            pstmt.setInt(2,vo.getManager_id());
            pstmt.setInt(3,vo.getLocation_id());
            pstmt.setInt(4,vo.getDepartment_id());

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
    public int delete(DeptVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from dept where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());

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
    public DeptVO selectOne(DeptVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        DeptVO vo2 =null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from dept where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new DeptVO();
                vo2.setDepartment_id(rs.getInt("department_id"));
                vo2.setDepartment_name(rs.getString("department_name"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setLocation_id(rs.getInt("location_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
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
    public List<DeptVO> selectAll() {
        System.out.println("selectAll()...");
        List<DeptVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from dept";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                DeptVO vo2 = new DeptVO();
                vo2.setDepartment_id(rs.getInt("department_id"));
                vo2.setDepartment_name(rs.getString("department_name"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setLocation_id(rs.getInt("location_id"));
                list.add(vo2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
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
    public List<DeptVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);
        List<DeptVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = " ";
            if (searchKey.equals("department_name")){
                sql = "select * from dept where department_name like ? order by department_id";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"%"+searchWord+"%");
            }else {
                sql = "select * from dept where manager_id=? order by department_id;";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(searchWord));
            }



            rs = pstmt.executeQuery();
            while (rs.next()){
                DeptVO vo2 = new DeptVO();
                vo2.setDepartment_id(rs.getInt("department_id"));
                vo2.setDepartment_name(rs.getString("department_name"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setLocation_id(rs.getInt("location_id"));
                list.add(vo2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
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
