package com.basic.sb_batch.repository;

import com.basic.sb_batch.domain.Product;
import com.basic.sb_batch.entity.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLogRepository extends JpaRepository<ProductLog,Long> {
    boolean existsByProduct(Product product);

}
