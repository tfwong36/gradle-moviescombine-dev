package com.oocl.moviescombine.dto;

public class SetPasswordRequest {
    private String id;
    private String password;

    public SetPasswordRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
