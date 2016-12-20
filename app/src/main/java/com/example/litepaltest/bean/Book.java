package com.example.litepaltest.bean;

/**
 * Created by zhang on 2016/12/20.
 */

public class Book {
    private int id;
    /**
     * 作者
     */
    private String author;
    /**
     * 价格
     */
    private double price;
    /**
     * 页数
     */
    private int pages;
    /**
     * 书名
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
