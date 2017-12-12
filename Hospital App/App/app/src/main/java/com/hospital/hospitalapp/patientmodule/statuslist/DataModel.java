package com.hospital.hospitalapp.patientmodule.statuslist;


public class DataModel {


    String name;
    String version;
    String date;
    int id_;
    int image;

    public DataModel(String name, String version,String date) {
        this.name = name;
        this.version = version;
        this.date = date;
      //  this.id_ = id_;
//        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }

    public String getDate() {
        return date;
    }
}