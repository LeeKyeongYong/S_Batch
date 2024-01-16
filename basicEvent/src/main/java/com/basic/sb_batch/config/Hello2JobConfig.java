package com.basic.sb_batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
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
public class Hello2JobConfig {
    /*
        Job이 두개일때는 applicaiton.yml 또는 application.properties에 지정한다.
        지정이될경우 자동으로 실행하고
        job이 두개일때는 job네임을 설정하지 않으면 에러가 발생한다.
     */


    @Bean
    public Job batch3Job(JobRepository jobRepository, Step batch3Step1, Step batch3Step2){
        return new JobBuilder("batch3Job",jobRepository)
                .start(batch3Step1)
                .next(batch3Step2)
                .incrementer(new RunIdIncrementer())
                .build();
    }

   // @JobScope
    @Bean
    public Step batch3Step1(JobRepository jobRepository, Tasklet batch3Step1Tasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("batch3Step1Tasklet",jobRepository)
                .tasklet(batch3Step1Tasklet,platformTransactionManager)
                .build();
    }
   // @StepScope
    @Bean
    public Tasklet batch3Step1Tasklet(){
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 2-1");
            return RepeatStatus.FINISHED;
        });
    }

    //@JobScope
    @Bean
    public Step batch3Step2(JobRepository jobRepository,Tasklet batch3Step2Tasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("batch3Step2Tasklet",jobRepository)
                .tasklet(batch3Step2Tasklet,platformTransactionManager)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet batch3Step2Tasklet(){
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 2-2");
            return RepeatStatus.FINISHED;
        });
    }
}
