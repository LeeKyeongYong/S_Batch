package com.basic.sb_batch.service;

import com.basic.sb_batch.domain.Product;
import com.basic.sb_batch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void create(String name){
        Product product = Product
                .builder()
                .name(name)
                .build();

        productRepository.save(product);
    }
}
