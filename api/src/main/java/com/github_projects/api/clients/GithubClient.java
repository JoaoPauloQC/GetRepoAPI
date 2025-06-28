package com.github_projects.api.clients;

import com.github_projects.api.model.Repo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GithubClient {

    private WebClient webClient;

    public GithubClient(WebClient.Builder builder){
        this.webClient = builder.baseUrl("https://api.github.com").build();
    }


    public Mono<Map> getUserInfo(String username){
        return webClient.get()
                .uri("/users/{username}",username)
                .retrieve()
                .bodyToMono(Map.class);
    }

    public Mono<List<Repo>> getRepos(String username){
        System.out.println("On client");
        return webClient.get()
                .uri("/users/{username}/repos" , username)
                .retrieve()
                .bodyToFlux(Repo.class)
                .collectList();

    }

    public Mono<HashMap> getLanguage(String repositoryname, String username){
        return webClient.get()
                .uri("/repos/{username}/{repositoryname}/languages" , username , repositoryname)
                .retrieve()
                .bodyToMono(HashMap.class);

    }

}
