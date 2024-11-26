package com.example.javarestapi;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base64")
public class Base64Controller {
    @GetMapping(value = "/encode/{text}")
    public String encode(@PathVariable String text) {
        return new String(Base64.getEncoder().encode(text.getBytes()));
    }

    @GetMapping(value = "/decode/{text}")
    public String decode(@PathVariable String text) {
        return new String(Base64.getDecoder().decode(text.getBytes()));
    }
}
