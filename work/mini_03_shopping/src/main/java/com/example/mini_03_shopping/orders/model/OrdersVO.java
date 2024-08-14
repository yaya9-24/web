package com.example.mini_03_shopping.orders.model;

public class OrdersVO {
    private int num;
    private String pname;
    private int sum;
    private String user_id;
    private int pnum;

    @Override
    public String toString() {
        return "OrdersVO{" +
                "num=" + num +
                ", pname='" + pname + '\'' +
                ", sum=" + sum +
                ", user_id='" + user_id + '\'' +
                ", pnum=" + pnum +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
}
