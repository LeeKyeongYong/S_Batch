package com.basic.sb_batch.config;

import org.springframework.batch.core.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class Hello3JobConfig {

    @Bean
    public Job hello3Job(JobRepository jobRepository, Step hello3Step1,Step hello3Step2,Step hello3Step3){
        return new JobBuilder("hello3Job",jobRepository)
                .start(hello3Step1)
                .next(hello3Step2)
                .next(hello3Step3)
                .incrementer(new RunIdIncrementer())
                .build();
    }
    @JobScope
    @Bean
    public Step hello3Step1(JobRepository jobRepository, Tasklet hello3Step1Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("hello3Step1Tasklet", jobRepository)
                .tasklet(hello3Step1Tasklet, platformTransactionManager)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet hello3Step1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 3-1");
            return RepeatStatus.FINISHED;
        });
    }

    @JobScope
    @Bean
    public Step hello3Step2(JobRepository jobRepository, Tasklet hello3Step2Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("hello3Step2Tasklet", jobRepository)
                .tasklet(hello3Step2Tasklet, platformTransactionManager)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet hello3Step2Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 3-2");
            return RepeatStatus.FINISHED;
        });
    }

    @JobScope
    @Bean
    public Step hello3Step3(JobRepository jobRepository, Tasklet hello3Step3Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("hello3Step3Tasklet", jobRepository)
                .tasklet(hello3Step3Tasklet, platformTransactionManager)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet hello3Step3Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 3-3");
            return RepeatStatus.FINISHED;
        });
    }
}
