package com.hashicorp.quickstart.domain;

public class Secret {
    private String password;

    public Secret() {}

    public Secret(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
