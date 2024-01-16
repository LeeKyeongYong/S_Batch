package com.basic.sb_batch.repository;

import com.basic.sb_batch.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
