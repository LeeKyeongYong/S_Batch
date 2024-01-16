package com.basic.sb_batch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
}
