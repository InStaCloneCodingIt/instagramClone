package org.insta.application.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommitTestController {

    @GetMapping("/test")
    public String test(){
        System.out.println("TTT");
        return "Hello Java";

    }
}