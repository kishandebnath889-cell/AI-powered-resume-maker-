package com.resume.backend1;


import com.resume.backend1.service.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ResumeAiBackendAAplicationTests{
    @Autowired
    private ResumeService resumeService;

    @Test
    void contextLoads() throws IOException {
        resumeService.generateResumeResponse("I am Kishan");
    }
}