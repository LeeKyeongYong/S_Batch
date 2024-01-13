package com.basic.sb_batch.batch_job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Batch2Service {
    private final JobLauncher jobLauncher;
    private final Job helloJob;

    public void runHelloJob(){
        try{
            JobParameters jobParameters = new JobParametersBuilder()
                    .toJobParameters();
            jobLauncher.run(helloJob,jobParameters);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
