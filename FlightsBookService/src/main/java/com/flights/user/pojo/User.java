package com.flights.user.pojo;

import javax.persistence.*;

@Entity
@Table(name = "sb_user")
public class User {

    public static final int ADMIN = 1;
    public static final int USER = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private int role_id;
    private boolean enabled;

    public User() {
    }

    public User(String email, String password, int role, boolean enabled) {
        this.email = email;
        this.password = password;
        this.role_id = role;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role_id;
    }

    public void setRole(int role_id) {
        this.role_id = role_id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
