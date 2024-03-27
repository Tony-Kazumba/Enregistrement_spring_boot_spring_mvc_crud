package com.tonycode.springboot.thymeleafcandidates.service;

import com.tonycode.springboot.thymeleafcandidates.entity.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();

    Candidate findById(int theId);

    Candidate save(Candidate theCandidate);


    void deleteById(int theId);

}
