package com.example.data;

import com.example.model.Category;
import com.sun.corba.se.impl.orbutil.CacheTable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dominikgromadzki on 03.04.2017.
 */

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1,"funny"),
            new Category(2,"sport"),
            new Category(3,"it")
    );


    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id) {
        for (Category category : ALL_CATEGORIES) {
            if(category.getId()==id)
                return category;
        }
        return null;
    }
}
