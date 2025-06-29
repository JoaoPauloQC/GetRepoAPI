package com.github_projects.api.controllers;

import com.github_projects.api.model.Repo;
import com.github_projects.api.services.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
@RequestMapping("api")
public class MainController {

    private MainService mainService;

    public MainController (MainService mainService){
        this.mainService = mainService;
    }


    @GetMapping("/user")
    public ResponseEntity<Mono<Map>> getUserInfo(){
        return ResponseEntity.ok(mainService.getUserInfo("JoaoPauloQC"));
    }

    @GetMapping("/user/repos")
    public Flux<Repo> getUserRepos(){
        return mainService.getRepos("JoaoPauloQC");
        //return ResponseEntity.ok(mainService.getRepos("JoaoPauloQC"));
    }

    @GetMapping("/user/languages")
    public Mono<HashMap> getlanguages(@RequestParam String reponame){
        return mainService.getRepoLanguages(reponame , "JoaoPauloQC");
    }

    @GetMapping("/user/languages/bytes")
    public Mono<Integer> getTotalBytes(@RequestParam String reponame){
        return mainService.getRepoTotalBytes(reponame , "JoaoPauloQC");
    }


}
