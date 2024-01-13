package com.basic.sb_batch.batch_job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class BasicJobConfig {
    /*
       인메모리로 작성한 프로젝트.(별다른 이유가 없어서 설정함)
        배치란 하나의 큰 폴더로 생각하면 됨.
        배치안에 여러개의 잡들이 있음
        하나의 잡에서는 다중의 스탭을 구성할수도 잇음.
        여래개의 1단위로 나누는 테스클릿과 청크방식이 존재.
        일반모드할경우 직접 batch하는 경우가있어서 DB생성해야함.. => Batch기록
        메모리 모드일경우 Batch테이블 만들지 않음.
      batch:
        jdbc:
          initialize-schema: always
          셋팅하면 h2테이블에 자동 생성이됨...

     잡은 같은 매개변수 구성으로 2번이상 실행되지 않는다.
     helloJob.run()을 하면 batch_job_execution 테이블에 이력이 생성이됨

     */

    //실행순서 3)
    @Bean
    public Job helloJob(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("helloJob", jobRepository)
                .start(simpleStep1)
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
