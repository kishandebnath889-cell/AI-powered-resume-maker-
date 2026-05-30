package com.resume.backend1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository
        extends MongoRepository<ResumeDocument, String> {
}