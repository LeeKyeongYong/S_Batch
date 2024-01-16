package com.basic.sb_batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BatchTestconfig {
    @Bean
    @Primary
    public JobLauncherTestUtils helloJobLauncherTestUtils(Job helloJob){
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(helloJob);
        return utils;
    }

    @Bean
    @Primary
    public JobLauncherTestUtils helloJobLauncherTestUtils2(Job batch3Job){
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(batch3Job);
        return utils;
    }

    @Bean
    @Primary
    public JobLauncherTestUtils helloJobLauncherTestUtils3(Job hello3Job) {
        JobLauncherTestUtils utils = new JobLauncherTestUtils();
        utils.setJob(hello3Job);
        return utils;
    }
}
