package com.scamchecker.scam_checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/check")
@CrossOrigin(origins = "*")
public class UrlCheckController {

    @Autowired
    private UrlCheckService urlCheckService;

    @GetMapping("/health")
    public String health() {
        return "Scam Checker is running!";
    }

    @PostMapping
    public String checkUrl(@RequestBody String url) {
        return urlCheckService.checkUrl(url);
    }
}
//
//
//        Save it, restart the server, then go to Postman:
//
//        - Method: **POST**
//        - URL: `http://localhost:8080/api/check`
//        - Body: **raw** → **Text**
//        - Paste this in the body:
//
//https://google.com