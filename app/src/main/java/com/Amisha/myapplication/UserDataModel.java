package com.Amisha.myapplication;

import java.io.Serializable;

public class UserDataModel implements Serializable {
    final String name;
    final int age;
    final String occupation;

    final String address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    public UserDataModel(String name, int age, String occupation, String address) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
    }
}
