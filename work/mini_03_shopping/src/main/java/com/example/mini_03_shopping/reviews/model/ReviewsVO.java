package com.example.mini_03_shopping.reviews.model;

import java.sql.Date;

public class ReviewsVO {
    private int num;
    private String content;
    private String writer;
    private Date wdate;
    private int bnum;

    @Override
    public String toString() {
        return "ReviewsVO{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", wdate=" + wdate +
                ", bnum=" + bnum +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }
}
