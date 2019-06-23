package com.creativeshare.emdad.models;

import java.io.Serializable;

public class ContainerModel implements Serializable {
    private int id;
    private String ar_title;
    private String en_title;
    private String trans_image;

    public int getId() {
        return id;
    }

    public String getAr_title() {
        return ar_title;
    }

    public String getEn_title() {
        return en_title;
    }

    public String getTrans_image() {
        return trans_image;
    }
}
