package com.projects.yur.carscatalog.Models;

/**
 * Created by Yur on 26.09.2016.
 */

public class Car {
    String name,model,price,location,desctription,feautures;
    String imageUrl;



    public Car() {


    }

    public Car(String name, String model, String price, String location, String desctription, String imageUrl,String feautures) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.location = location;
        this.desctription = desctription;
        this.imageUrl = imageUrl;
        this.feautures=feautures;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                ", desctription='" + desctription + '\'' +
                ", feautures='" + feautures + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctription) {
        this.desctription = desctription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getFeautures() {
        return feautures;
    }

    public void setFeautures(String feautures) {
        this.feautures = feautures;
    }
}
