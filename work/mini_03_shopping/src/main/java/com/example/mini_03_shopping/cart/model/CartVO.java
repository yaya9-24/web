package com.example.mini_03_shopping.cart.model;

public class CartVO {
    private int num;
    private String pname;
    private int price;
    private int count;
    private int cart_id;

    @Override
    public String toString() {
        return "CartVO{" +
                "num=" + num +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", cart_id=" + cart_id +
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }
}
