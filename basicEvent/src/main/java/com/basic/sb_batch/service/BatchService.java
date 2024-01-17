package com.basic.sb_batch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final JobLauncher jobLauncher;
    private final Job helloJob;
    private final Job makeProductLogJob;


    public void runMakeProductLogJob(LocalDateTime startDate_, LocalDateTime endDate_) {
            try{
                String startDate = startDate_.toString().substring(0,10)+" 00:00:00.000000";
                String endDate = endDate_.toString().substring(0,10)+" 23:59:59.999999";

                JobParameters jobParameters = new JobParametersBuilder()
                        .addString("startDate",startDate)
                        .addString("endDate",endDate)
                        .toJobParameters();
                jobLauncher.run(makeProductLogJob,jobParameters);

            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
