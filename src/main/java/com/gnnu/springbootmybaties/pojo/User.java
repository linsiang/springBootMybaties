package com.gnnu.springbootmybaties.pojo;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String uname;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }
}

