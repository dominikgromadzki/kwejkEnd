package com.example.controller;

import com.example.data.GifRepository;
import com.example.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dominikgromadzki on 31.03.2017.
 */

@Controller
public class GifController {


    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getAllGifs());
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = new Gif("compiler-bot", "michalos", true);
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }

    @GetMapping("/favorites")
    public String getFavorites(ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.getFavGif());
        return "favorites";

    }

    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif=gifRepository.findByName(name);
        modelMap.addAttribute("gif", gif);
        return "gif-details";
    }
}
