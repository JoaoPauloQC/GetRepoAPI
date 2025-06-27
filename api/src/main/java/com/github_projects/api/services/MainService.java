package com.github_projects.api.services;

import com.github_projects.api.clients.GithubClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

}
