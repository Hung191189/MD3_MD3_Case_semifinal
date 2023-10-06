package com.example.case_md3.model;

public class User {
    private int idUser;
    private String name;
    private int age;
    private String email;
    private String address;
    private String password;
    private int status;
    private static int INDEX = 0;
    public User() {
    }

    public User(String name, int age, String email, String address, String password, int status) {
        this.idUser = ++INDEX;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.password = password;
        this.status = status;
    }

    public User(int idUser, String name, int age, String email, String address, int status) {
        this.idUser = idUser;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.status = status;
    }

    public User(int idUser, String name, int age, String email, String address, String password, int status) {
        this.idUser = idUser;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.password = password;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
