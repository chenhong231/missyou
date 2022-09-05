package com.lin.eshopping.service;

import com.lin.eshopping.model.Category;
import com.lin.eshopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Map getAll() {
        List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);

        Map<Integer, List<Category>> categories = new HashMap<>();
        categories.put(1, roots);
        categories.put(2, subs);
        return categories;
    }
}
