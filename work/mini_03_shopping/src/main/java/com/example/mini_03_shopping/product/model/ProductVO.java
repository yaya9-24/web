package com.example.mini_03_shopping.product.model;

public class ProductVO {

    private int num;
    private String pname;
    private int price;
    private String imgName;

    @Override
    public String toString() {
        return "ProductVO{" +
                "num=" + num +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", imgName='" + imgName + '\'' +
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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
