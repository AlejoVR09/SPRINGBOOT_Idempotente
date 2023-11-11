package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class idempotente {
    private String id;

    @GetMapping("/exa/{id}")
    public String exampleGet(@PathVariable String idGet) {
        if (id == null) {
            id = idGet;
        }

        return id;
    }

    private String postData;

    @PostMapping("/exa")
    public String examplePost(@RequestBody String data) {
        // Lógica de la operación idempotente
        if (postData == null) {
            postData = data;
        }

        return postData;
    }
}