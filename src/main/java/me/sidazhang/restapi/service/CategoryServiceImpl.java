package me.sidazhang.restapi.service;

import me.sidazhang.restapi.api.v1.DTO.CategoryDTO;
import me.sidazhang.restapi.api.v1.mapper.CategoryMapper;
import me.sidazhang.restapi.model.Category;
import me.sidazhang.restapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryMapper categoryMapper;
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Optional<Category> category=categoryRepository.findByName(name);
        if(!category.isPresent()){throw new ResourceNotFoundException();}
        return categoryMapper.categoryToCategoryDTO(category.get());
    }
}
