package com.creativeshare.emdad.Model;

import java.io.Serializable;

public class Information_Model  implements Serializable {

       private int id_def_details;
            private String ar_title;
           private String en_title;
           private String image;
            private int availble;
           private String ar_content;
           private String en_content;
           private int key_id_fk;
           private  int id_def;

    public int getId_def_details() {
        return id_def_details;
    }

    public String getAr_title() {
        return ar_title;
    }

    public String getEn_title() {
        return en_title;
    }

    public String getImage() {
        return image;
    }

    public int getAvailble() {
        return availble;
    }

    public String getAr_content() {
        return ar_content;
    }

    public String getEn_content() {
        return en_content;
    }

    public int getKey_id_fk() {
        return key_id_fk;
    }

    public int getId_def() {
        return id_def;
    }
}
