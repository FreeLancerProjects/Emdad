package com.creativeshare.emdad.Model;

import java.io.Serializable;
import java.util.List;

public class Bank_Model implements Serializable {
private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    private class Data implements Serializable{
        private int id;
        private String account_name;
        private String account_IBAN;
        private String account_bank_name;
        private String account_number;

        public int getId() {
            return id;
        }

        public String getAccount_name() {
            return account_name;
        }

        public String getAccount_IBAN() {
            return account_IBAN;
        }

        public String getAccount_bank_name() {
            return account_bank_name;
        }

        public String getAccount_number() {
            return account_number;
        }
    }


}
