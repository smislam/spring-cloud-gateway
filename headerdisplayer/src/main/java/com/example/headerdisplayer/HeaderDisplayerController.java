package com.example.headerdisplayer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class HeaderDisplayerController {

    @GetMapping("/")
    public String home(@RequestHeader Map<String, String>headers) throws JsonProcessingException {

        Map<String, String> h = new HashMap<>();
        headers.forEach((key, val) -> {
            h.put(key, val);
        });

        return new ObjectMapper().writeValueAsString(h);
    }
    
}
