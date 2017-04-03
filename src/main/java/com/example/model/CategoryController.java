package com.example.model;

import com.example.data.CategoryRepository;
import com.example.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dominikgromadzki on 03.04.2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.getAllCategories());
        return "categories";
    }

    @RequestMapping("/category/{categoryId}")
    public String category(@PathVariable int categoryId, ModelMap modelMap) {
        Category category = categoryRepository.findById(categoryId);
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("gifs", gifRepository.findById(categoryId));
        return "category";
    }

}
