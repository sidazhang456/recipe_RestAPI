package me.sidazhang.restapi.service;

import me.sidazhang.restapi.api.v1.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
