package com.github_projects.api.model;

public class Repo {

    private int id;
    private String user;
    private String name;

    public Repo(String name, int id){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

}
