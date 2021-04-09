package com.example.lektion1.model;

/**
 * Created by Christoffer Grännby
 * Date: 2021-04-09
 * Time: 11:16
 * Project: Lektion1
 * Copyright: MIT
 */
public class Friends {

    private int id;
    private String name;
    private String adress;
    private String number;

    public Friends(){}

    public Friends(int id, String name, String adress, String number){
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
