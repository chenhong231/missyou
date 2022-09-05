package com.lin.eshopping.api.v1;

import com.lin.eshopping.exception.http.NotFoundException;
import com.lin.eshopping.model.Category;
import com.lin.eshopping.model.GridCategory;
import com.lin.eshopping.repository.GridCategoryRepository;
import com.lin.eshopping.service.CategoryService;
import com.lin.eshopping.service.GridCategoryService;
import com.lin.eshopping.vo.CategoriesAllVO;
import com.lin.eshopping.vo.CategoryPureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

    @RequestMapping("/all")
    public CategoriesAllVO getAll() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        return new CategoriesAllVO(categories);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList() {
        List<GridCategory> gridCategoryList = gridCategoryService.getGridCategoryList();

        if(gridCategoryList.isEmpty()) {
            throw new NotFoundException(30009);
        }

        return gridCategoryList;
    }
}
