package com.basic.sb_batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchTestConfig {
    @Bean
    public JobLauncherTestUtils helloJobLauncherTestUtils(Job helloJob) {
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(helloJob);
        return utils;
    }

    @Bean
    public JobLauncherTestUtils helloJobLauncherTestUtils2(Job hello2Job) {
        JobLauncherTestUtils utils2 = new JobLauncherTestUtils();
        utils2.setJob(hello2Job);
        return utils2;
    }
}
