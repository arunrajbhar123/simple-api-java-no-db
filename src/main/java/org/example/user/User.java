package org.example.user;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;


public class User implements Serializable {
    private static int nextId = 1;
    private int id;

    private String firstName;
    private String secondName;
    private String dob;

    public User(String firstName, String secondName, String dob) {
        this.id = nextId++;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dob = dob;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isEqual(User payload) {
        return payload != null &&
                Objects.equals(this.firstName, payload.getFirstName()) &&
                Objects.equals(this.secondName, payload.getSecondName()) &&
                Objects.equals(this.dob, payload.getDob());
    }
}

