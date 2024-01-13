package com.basic.sb_batch.batch_job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;
import org.springframework.batch.core.Job;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final JobLauncher jobLauncher;
    private final Job simpleJob;

    public void runSimpleJob(){
        try{
            JobParameters jobParameters = new JobParametersBuilder()
                    .toJobParameters();
            jobLauncher.run(simpleJob,jobParameters);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
