package com.basic.sb_batch.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class Hello5JobConfig {
    @Bean
    public Job hello5Job(JobRepository jobRepository, Step hello5Step1){
        return new JobBuilder("hello5Job",hello5Step1)
                .start(hello5Step1)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @JobScope
    @Bean
    public Step hello5Step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("hello5Step1",jobRepository)
                .<Integer,String>chunk(10,platformTransactionManager)
                .reader(()->{
                    Integer no = (int)(Math.random()*100);

                    if(no==50) return  null;
                    return no;
                })
                .processor(
                        item -> "NO. "+item
                ).writer(chunk -> {
                    chunk ->{
                        List<? extends String> items = chunk.getItems();
                        for(String item: items){
                            System.out.println("item = "+item);
                        }
                    }
                }).build();
    }

}
