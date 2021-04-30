package com.khlaedahmmedanik.healthconditionpredictor;

import java.util.ArrayList;
import java.util.List;

public class userOfAllType {

    String name,password,email, role;
    List<diseaseInfo> previousInfo=new ArrayList<diseaseInfo>();

    public userOfAllType() {
    }

    public userOfAllType(String name, String password, String email, String role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public List<diseaseInfo> getPreviousInfo() {
        return previousInfo;
    }

    public void setPreviousInfo(List<diseaseInfo> previousInfo) {
        this.previousInfo = previousInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

