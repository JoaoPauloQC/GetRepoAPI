package com.github_projects.api.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

}
