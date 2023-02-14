package org.insta.application.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/auth/login")
    public String authLogin(){
        return "/auth/login";
    }
}
