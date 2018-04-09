package me.sidazhang.restapi.repository;

import me.sidazhang.restapi.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
}
