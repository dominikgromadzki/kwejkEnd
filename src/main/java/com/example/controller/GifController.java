package com.example.controller;

import com.example.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dominikgromadzki on 31.03.2017.
 */

@Controller
public class GifController {



    @GetMapping("/")
    public String listGifs(){
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        Gif gif = new Gif("compiler-bot","michalos",true); modelMap.put("gif",gif);
        return "gif-details";
    }
}
