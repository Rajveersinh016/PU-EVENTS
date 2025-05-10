package com.example.pu;

public class DataClass {

    private String data_Name;

    private String data_Date;

    private String data_Time;

    private String data_Place;

    private String data_image;

    private  String data_Cell;

    public String getData_Cell() {
        return data_Cell;
    }

    public String getData_Name() {
        return data_Name;
    }

    public String getData_Date() {
        return data_Date;
    }

    public String getData_Time() {
        return data_Time;
    }

    public String getData_Place() {
        return data_Place;
    }


    public String getData_image() {
        return data_image;
    }

    public DataClass(String data_Name, String data_Date, String data_Time, String data_Place,String data_Cell, String data_image) {
        this.data_Name = data_Name;
        this.data_Date = data_Date;
        this.data_Time = data_Time;
        this.data_Place = data_Place;
        this.data_Cell = data_Cell;
        this.data_image = data_image;

    }


    public  DataClass(){


    }
}
