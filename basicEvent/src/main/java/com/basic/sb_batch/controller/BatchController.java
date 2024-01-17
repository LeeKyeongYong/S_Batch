package com.basic.sb_batch.controller;


import com.basic.sb_batch.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @GetMapping("/makeProductLog")
    @ResponseBody
    public String runMakeProductLogJob(){
        LocalDateTime startDate = LocalDateTime
                .now()
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        LocalDateTime endDate = LocalDateTime
                .now()
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999);
        batchService.runMakeProductLogJob(
                startDate,
                endDate
        );

        return "makeProductLog Ok";
    }
}
