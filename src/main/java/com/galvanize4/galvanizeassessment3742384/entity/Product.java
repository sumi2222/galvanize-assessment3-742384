package com.galvanize4.galvanizeassessment3742384.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class Product implements Comparable<Product>{

    private int product_id;
    private String category;
    private String brand;
    private String color;
    private Double price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public int compareTo(Product p) {
        return this.price.compareTo(p.price);
    }

    public Product(int product_id, String category, String brand, String color, Double price) {
        this.product_id = product_id;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}