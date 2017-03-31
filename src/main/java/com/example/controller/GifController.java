package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by dominikgromadzki on 31.03.2017.
 */

@Controller
public class GifController {

    @GetMapping("/")
    public String listGifs(){
        return "home";
    }
}
