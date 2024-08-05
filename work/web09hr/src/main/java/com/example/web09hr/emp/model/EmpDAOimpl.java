package com.example.web09hr.emp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAOimpl implements EmpDAO{
    private static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
    private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER="hr";
    private static final String PASSWORD="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public EmpDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(EmpVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into emp(employee_id,first_name,last_name,email,phone_number" +
                    " ,hire_date,job_id,salary,commission_pct,manager_id,department_id) " +
                    " values(employees_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getFirst_name());
            pstmt.setString(2,vo.getLast_name());
            pstmt.setString(3,vo.getEmail());
            pstmt.setString(4,vo.getPhone_number());
            pstmt.setDate(5,vo.getHire_date());
            pstmt.setString(6,vo.getJob_id());
            pstmt.setInt(7,vo.getSalary());
            pstmt.setDouble(8,vo.getCommission_pct());
            pstmt.setInt(9,vo.getManager_id());
            pstmt.setInt(10,vo.getDepartment_id());

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
    public int update(EmpVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update emp set email=?,phone_number=?" +
                    ",job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=?" +
                    " where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getEmail());
            pstmt.setString(2,vo.getPhone_number());
            pstmt.setString(3,vo.getJob_id());
            pstmt.setInt(4,vo.getSalary());
            pstmt.setDouble(5,vo.getCommission_pct());
            pstmt.setInt(6,vo.getManager_id());
            pstmt.setInt(7,vo.getDepartment_id());
            pstmt.setInt(8,vo.getEmployee_id());

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
    public int delete(EmpVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from emp where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getEmployee_id());

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
    public EmpVO selectOne(EmpVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        EmpVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from emp where employee_id=? order by employee_id desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getEmployee_id());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new EmpVO();
                vo2.setEmployee_id(rs.getInt("employee_id"));
                vo2.setFirst_name(rs.getString("first_name"));
                vo2.setLast_name(rs.getString("last_name"));
                vo2.setEmail(rs.getString("email"));
                vo2.setPhone_number(rs.getString("phone_number"));
                vo2.setHire_date(rs.getDate("hire_date"));
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setSalary(rs.getInt("salary"));
                vo2.setCommission_pct(rs.getInt("commission_pct"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setDepartment_id(rs.getInt("department_id"));
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
    public List<EmpVO> selectAll() {
        System.out.println("selectAll()...");
        List<EmpVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from emp order by employee_id desc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getDate("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getInt("salary"));
                vo.setCommission_pct(rs.getInt("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
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
    public List<EmpVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println("searchKey:"+searchKey);
        System.out.println("searchWord:"+searchWord);
        List<EmpVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "";
            if (searchKey.equals("first_name")){
                sql = "select * from emp where first_name like ? order by employee_id desc";
            } else if (searchKey.equals("job_id")) {
                sql = "select * from emp where job_id like ? order by employee_id desc";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getDate("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getInt("salary"));
                vo.setCommission_pct(rs.getInt("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
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
