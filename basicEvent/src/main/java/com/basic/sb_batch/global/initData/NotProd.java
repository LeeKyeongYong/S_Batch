package com.basic.sb_batch.global.initData;


import com.basic.sb_batch.domain.Product;
import com.basic.sb_batch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Autowired
    @Lazy
    private NotProd self;
    private final ProductService productService;

    @Bean
    ApplicationRunner initNotProd(){
        return args->{
            self.work1();
        };
    }

    @Transactional
    public void work1(){

        //IntStream.rangeClosed(1,100).forEach(i -> productService.create("product "+i));
        IntStream.rangeClosed(0,50).forEach(i->{
            Product product = productService.create("product"+i);
            product.setCreatedDate(LocalDateTime.now().minusDays(i));
        });
        IntStream.rangeClosed(1,100).forEach(i -> productService.create("product "+i));
    }
}
