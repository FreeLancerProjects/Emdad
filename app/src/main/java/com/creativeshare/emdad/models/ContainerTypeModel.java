package com.creativeshare.emdad.models;

import java.io.Serializable;

public class ContainerTypeModel implements Serializable {

    private int id;
    private String ar_type;
    private String en_type;


    public ContainerTypeModel(String ar_type, String en_type) {
        this.ar_type = ar_type;
        this.en_type = en_type;
    }

    public int getId() {
        return id;
    }

    public String getAr_type() {
        return ar_type;
    }

    public String getEn_type() {
        return en_type;
    }
}
