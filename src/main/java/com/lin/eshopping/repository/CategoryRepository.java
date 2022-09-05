package com.lin.eshopping.repository;

import com.lin.eshopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);

}
