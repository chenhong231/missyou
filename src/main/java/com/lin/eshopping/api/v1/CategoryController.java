package com.lin.eshopping.api.v1;

import com.lin.eshopping.vo.CategoriesAllVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("category")
@RestController
public class CategoryController {

    @RequestMapping("/all")
    public CategoriesAllVO getAll() {
        return null;
    }
}
