package com.example.web09hr.job.model;

import java.util.List;

public interface JobDAO {
    public boolean cname(String str);
    public int insert(JobVO vo);
    public int update(JobVO vo);
    public int delete(JobVO vo);
    public JobVO selectOne(JobVO vo);
    public JobVO job_idCheck(String job_id);
    public List<JobVO> selectAll();
    public List<JobVO> searchList(String searchKey, String searchWord);
}
