package com.github_projects.api.services;

import com.github_projects.api.clients.GithubClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    private GithubClient githubClient;

    public MainService(GithubClient githubClient){
        this.githubClient = githubClient;
    }

    public Mono<Map> getUserInfo(String Username){
        return githubClient.getUserInfo(Username);
    }

    public Mono<Object> getRepos(String Username){
        System.out.println("On Service");
        Mono<ArrayList> repoList = githubClient.getRepos(Username);
        Mono<Object> reponames;
        reponames = repoList.map(repo -> repo.get(0));
        return reponames;
    }

}
