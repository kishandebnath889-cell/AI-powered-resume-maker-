package com.resume.backend1.controller;

import com.resume.backend1.ResumeDocument;
import com.resume.backend1.ResumeRepository;
import com.resume.backend1.ResumeRequest;
import com.resume.backend1.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/resume")

public class ResumeController{

    private ResumeService resumeService;

    @Autowired
    private ResumeRepository resumeRepository;

    public ResumeController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @PostMapping("/generate")
    public ResponseEntity <Map<String, Object>> getResumeData(
            @RequestBody ResumeRequest resumeRequest
    ) throws IOException {
      Map<String, Object> stringObjectMap =  resumeService.generateResumeResponse(resumeRequest.userDescription());
      return new ResponseEntity<>(stringObjectMap, HttpStatus.OK);
    }
    @PostMapping("/api/v1/resume/save")
    public ResponseEntity<?> saveResume(@RequestBody Map<String, Object> resumeData) {
        System.out.println("Save endpoint hit!"); // ✅ Add this
        System.out.println("Data received: " + resumeData); // ✅ Add this

        ResumeDocument doc = new ResumeDocument();
        doc.setResumeData(resumeData);
        resumeRepository.save(doc);

        System.out.println("Saved successfully!"); // ✅ Add this
        return ResponseEntity.ok("Saved successfully");
    }
}