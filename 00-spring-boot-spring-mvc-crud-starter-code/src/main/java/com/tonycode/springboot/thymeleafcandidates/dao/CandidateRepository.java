package com.tonycode.springboot.thymeleafcandidates.dao;

import com.tonycode.springboot.thymeleafcandidates.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    // added method to sort by position
    public List<Candidate> findAllByOrderByPositionAsc();



}
