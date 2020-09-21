package com.jdy.spring2020.bean;

public class Car {

    private String brand;
    private String price;

    public Car(String brand, String price) {
        this.brand = brand;
        this.price = price;
    }

    public void inti_method(){
        System.out.println("Car-inti_method....");
    }

    public void destory_method(){
        System.out.println("Car-destory_method....");
    }

    public Car() {
        System.out.println("Car-无参构造....");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("Car-setBrand方法....");
        this.brand = brand;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
