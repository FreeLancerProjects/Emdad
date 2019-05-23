package com.creativeshare.emdad.Model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int user_id;
    private String name;
    private String user_name;
    private String email;
    private String phone_code;
    private String phone;
    private String image;
    private String address;
    private double let;
    private double lang;
    private int activity;
    private int software_type;
    private int accpted;
    private int user_type;
    private int is_login;
    private String created_at;
    private String updated_at;

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public String getPhone() {
        return phone;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public double getLet() {
        return let;
    }

    public double getLang() {
        return lang;
    }

    public int getActivity() {
        return activity;
    }

    public int getSoftware_type() {
        return software_type;
    }

    public int getAccpted() {
        return accpted;
    }

    public int getUser_type() {
        return user_type;
    }

    public int getIs_login() {
        return is_login;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
