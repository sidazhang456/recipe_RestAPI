package me.sidazhang.restapi.repository;

import me.sidazhang.restapi.model.Category;
import me.sidazhang.restapi.service.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
