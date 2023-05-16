package com.company.testingsystem.server.model;

import com.company.testingsystem.server.enums.Role;

import java.util.UUID;

public class User implements Comparable<User>{
    private final String name;
    private final String username;
    private String password;
    private final UUID id;
    private final Role role;

    public User(String name, String username, String password, UUID id, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
        this.role = role;
    }

    public User(String name, String username, String password, UUID id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
        this.role = Role.STUDENT;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public int compareTo(User u) {
        return id.compareTo(u.id);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", role=" + role +
                '}';
    }
}
