package com.basic.sb_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchTestConfig {
    @Bean
    public JobLauncherTestUtils helloJobLauncherTestUtils(Job helloJob){
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(helloJob);
        return utils;
    }

    @Bean
    public JobLauncherTestUtils helloJobLauncherTestUtils2(Job helloJob2){
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(helloJob2);
        return utils;
    }
}
