package com.projects.yur.carscatalog.Models;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Yur on 28.09.2016.
 */

public class User extends RealmObject implements Serializable {
    @PrimaryKey
    private int id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(int id, String Username,String Password,  String Email, String Phone,String FullName) {
        this.id = id;
        this.password = Password;
        this.fullName=FullName;
        this.username = Username;
        this.email = Email;
        this.phone = Phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String mPassword) {
        this.password = mPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
}
