package com.basic.sb_batch.batch_job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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
public class SecondBasiJobConfig {

    /*
     job:
      enabled: false
    대신
    .incrementer(new RunIdincrementer()) 사용
     */
    //실행순서 3)
    @Bean
    public Job helloJob(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("helloJob", jobRepository)
                .start(simpleStep1)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    //실행순서 2)

    @Bean
    public Step helloStep1(JobRepository jobRepository, Tasklet helloStep1Tasklet1, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("helloStep1Tasklet1", jobRepository)
                .tasklet(helloStep1Tasklet1, platformTransactionManager)
                .build();
    }

    //실행순서 1)
    @Bean
    public Tasklet helloStep1Tasklet1(){
        return ((contribution, chunkContext) -> {
            log.info("Hello World");
            System.out.println("Hello World");
            return RepeatStatus.FINISHED;
        });
    }
}
