package com.resume.backend1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Document(collection = "resumes")
public class ResumeDocument {
    @Id
    private String id;
    private Map<String, Object> resumeData;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Map<String, Object> getResumeData() { return resumeData; }
    public void setResumeData(Map<String, Object> resumeData) {
        this.resumeData = resumeData;
    }
}