package me.sidazhang.restapi.repository;

import me.sidazhang.restapi.model.Category;
import me.sidazhang.restapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
