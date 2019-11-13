package com.authorization.model;

public class AuthenticationRequest {
    private long userid;
    private String username;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(long userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
