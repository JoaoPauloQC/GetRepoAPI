package com.github_projects.api.responses;

import java.util.ArrayList;
import java.util.List;

public class RepoResponse {

    private String name;
    private int id;
    private List languages;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List getLanguages() {
        return languages;
    }
}
