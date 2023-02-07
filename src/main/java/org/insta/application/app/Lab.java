package org.insta.application.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lab {

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
    @GetMapping("/api/v1/test")
    public ResponseEntity<Map<String,Object>> testRest() {
        Map<String, Object> map = new HashMap<>();
        map.put("Commit","Test");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
