package com.basic.sb_batch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class Hello3JobConfig {

    /*
       return new JobBuilder("hello3Job",jobRepository)
                .start(hello3Step1)
                .next(hello3Step2)
                .next(hello3Step3)
                .incrementer(new RunIdIncrementer())
                .build();
                */
    @Bean
    public Job hello3Job( JobRepository jobRepository,
                          Step hello3Step1,
                          Step hello3Step2,
                          Step hello3Step3){

        Flow flow1 = new FlowBuilder<SimpleFlow>("flow1")
                .start(hello3Step1)
                .build();

        Flow flow2 = new FlowBuilder<SimpleFlow>("flow2")
                .start(hello3Step2)
                .build();

        Flow parallelFlow = new FlowBuilder<SimpleFlow>("parallelFlow")
                .split(new SimpleAsyncTaskExecutor()) // 병렬 실행을 위한 실행기 설정
                .add(flow1, flow2)
                .build();

        FlowJobBuilder jobBuilder = new JobBuilder("hello3Job", jobRepository)
                .start(parallelFlow)
                .next(hello3Step3)
                .end()
                .incrementer(new RunIdIncrementer());

        return jobBuilder.build();
    }
    //@JobScope
    @Bean
    public Step hello3Step1(JobRepository jobRepository, Tasklet hello3Step1Tasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("hello3Step1Tasklet", jobRepository)
                .tasklet(hello3Step1Tasklet, platformTransactionManager)
                .build();
    }

    //@StepScope
    @Bean
    public Tasklet hello3Step1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("Hello World 3-1");
            return RepeatStatus.FINISHED;
        });
    }

    //@JobScope
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
