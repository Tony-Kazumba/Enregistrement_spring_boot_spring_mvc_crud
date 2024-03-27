package com.tonycode.springboot.thymeleafcandidates.service;

import com.tonycode.springboot.thymeleafcandidates.dao.CandidateRepository;
import com.tonycode.springboot.thymeleafcandidates.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository theEmployeeRepository) {
        candidateRepository = theEmployeeRepository;
    }

    @Override
    public List<Candidate> findAll() {

        return candidateRepository.findAllByOrderByPositionAsc();
    }

    @Override
    public Candidate findById(int theId) {
        Optional<Candidate> result = candidateRepository.findById(theId);

        Candidate theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Candidate save(Candidate theEmployee) {
        return candidateRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        candidateRepository.deleteById(theId);
    }
}






