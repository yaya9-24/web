package com.example.web09hr.job.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAOimpl implements JobDAO{

    private static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
    private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER="hr";
    private static final String PASSWORD="hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public JobDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean cname(String str) {
        Boolean isDuplicate = false;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select job_id from job";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                if (str.equals(rs.getString("job_id"))) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate==false){
                System.out.println("사용 가능한 아이디입니다.");
            } else if (isDuplicate ==true) {
                System.out.println("중복된 아이디입니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDuplicate;
    }

    @Override
    public int insert(JobVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "insert into job(job_id,job_title,min_salary,max_salary)"+
                    "values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_id());
            pstmt.setString(2,vo.getJob_title());
            pstmt.setInt(3,vo.getMin_salary());
            pstmt.setInt(4,vo.getMax_salary());


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
    public int update(JobVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "update job set job_title=? where job_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_title());
            pstmt.setString(2,vo.getJob_id());

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
    public int delete(JobVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn successed...");

            String sql = "delete from job where job_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_id());

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
    public JobVO selectOne(JobVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        JobVO vo2 =null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from job where job_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_id());

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new JobVO();
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setJob_title(rs.getString("job_title"));
                vo2.setMin_salary(rs.getInt("min_salary"));
                vo2.setMax_salary(rs.getInt("max_salary"));
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
    public JobVO job_idCheck(String job_id) {
        System.out.println("job_idCheck()...");
        System.out.println(job_id);
        JobVO vo2 =null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from job where job_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,job_id);

            rs = pstmt.executeQuery();
            while (rs.next()){
                vo2 = new JobVO();
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
    public List<JobVO> selectAll() {
        System.out.println("selectAll()...");
        List<JobVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "select * from job order by job_id asc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()){
                JobVO vo2 = new JobVO();
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setJob_title(rs.getString("job_title"));
                vo2.setMin_salary(rs.getInt("min_salary"));
                vo2.setMax_salary(rs.getInt("max_salary"));
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
    public List<JobVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        List<JobVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = " ";
            if (searchKey.equals("job_title")){
                sql = "select * from job where job_title like ? order by job_id asc";
            } else if (searchKey.equals("job_id")) {
                sql = "select * from job where job_id like ? order by job_id asc";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();
            while (rs.next()){
                JobVO vo2 = new JobVO();
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setJob_title(rs.getString("job_title"));
                vo2.setMin_salary(rs.getInt("min_salary"));
                vo2.setMax_salary(rs.getInt("max_salary"));
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
