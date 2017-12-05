package com.xmu.crms.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class AccountController {

    @GetMapping("/me")
    public String selectMe() {
        return "";
    }

    @PutMapping("/me")
    public String updateMe() {

        return "";

    }
}