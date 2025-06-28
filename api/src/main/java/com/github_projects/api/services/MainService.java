package com.github_projects.api.services;

import com.github_projects.api.clients.GithubClient;
import com.github_projects.api.model.Repo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
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

    public Flux<Repo> getRepos(String Username){
        Flux<String> reponames;
        System.out.println("On Service");
        Flux<Repo> repoList = githubClient.getRepos(Username).flatMapMany(Flux:: fromIterable);

        reponames = repoList.map(repo -> repo.getName());

        return repoList;
    }

    public Mono<HashMap> getRepoLanguages(String reponame , String username){

        Mono<HashMap> languagehashmap = githubClient.getLanguage(reponame, username);
        return languagehashmap;
    }


}
