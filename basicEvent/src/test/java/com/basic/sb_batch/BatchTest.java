package com.basic.sb_batch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@SpringBatchTest
@ActiveProfiles("test")
public class BatchTest {

    //Autowired 를 두번해야한다.. 이름은 별개로 선언..

    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils;

    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils2;

    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils3;

    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils4;


    @Autowired
    private JobLauncherTestUtils helloJobLauncherTestUtils5;

    @DisplayName("첫번째 배치")
    @Test
    public void 첫번째배치테스트() throws Exception{
        helloJobLauncherTestUtils.launchJob();
    }

    @DisplayName("두번째 배치")
    @Test
    public void 두번째배치테스트() throws Exception{
        helloJobLauncherTestUtils2.launchJob();
    }

    @DisplayName("세번째 배치")
    @Test
    public void 세번째배치테스트() throws Exception{
        helloJobLauncherTestUtils3.launchJob();
    }

    @DisplayName("네번째 배치")
    @Test
    public void 네번째배치테스트() throws Exception{
        helloJobLauncherTestUtils4.launchJob();
    }

    @DisplayName("다섯번째 배치")
    @Test
    public void 다섯번째배치테스트() throws Exception{
        helloJobLauncherTestUtils5.launchJob();
    }

    @DisplayName("여섯번째 배치")
    @Test
    public void 여섯번째배치테스트() throws Exception{
        String startDate = LocalDateTime.now().minusDays(1).toString().substring(0,10)+"00:00:00.000000";
        String endDate = LocalDateTime.now().minusDays().toString().substring(0,10)+"23:59:59.999999";

        JobParameter jobParameter = new JobParametersBuilder()
                .addString("startDate",startDate)
                .addString("endDate",endDate)
                .toJobParameters();

        makeProductLogJobLauncherTestUtils.launchJob(jobParameter);
    }
}
