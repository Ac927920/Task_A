package com.example.testa;

import java.util.List;

public class CountryResponse {
    private int status;
    private String message;
    private List<Country> data;

    // Constructors, getters, setters


    public CountryResponse(int status, String message, List<Country> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Country> getData() {
        return data;
    }

    public void setData(List<Country> data) {
        this.data = data;
    }
}
