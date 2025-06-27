package com.github_projects.api.controllers;

import com.github_projects.api.services.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

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

}
