package com.basic.sb_batch.batch_job;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/batch")
@RequiredArgsConstructor
public class Batch2Controller {

    private final Batch2Service batchService;
    @GetMapping("/hello")
    @ResponseBody
    public String runHelloJob(){
        batchService.runHelloJob();
        return "HelloSimpleJob Ok";
    }
}
