package me.sidazhang.restapi.api.v1.mapper;

import me.sidazhang.restapi.api.v1.DTO.CategoryDTO;
import me.sidazhang.restapi.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "id",target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
