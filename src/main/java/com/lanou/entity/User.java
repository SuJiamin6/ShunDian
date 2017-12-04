package com.lanou.entity;

/**
 * Created by lanou on 2017/12/1.
 */
public class User {

    private Integer uId;
    private  String uName;
    private  String uPassword;
    private  String uPhone;


    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public User(String uName, String uPassword, String uPhone) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uPhone='" + uPhone + '\'' +
                '}';
    }

    public User() {
        super();
    }


}
