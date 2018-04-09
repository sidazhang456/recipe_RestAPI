package me.sidazhang.restapi.api.v1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.sidazhang.restapi.model.Category;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    private List<CategoryDTO> categories;
}
