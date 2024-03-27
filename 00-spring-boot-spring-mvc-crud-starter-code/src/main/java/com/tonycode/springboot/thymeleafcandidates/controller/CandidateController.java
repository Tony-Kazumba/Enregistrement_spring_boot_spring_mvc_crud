package com.tonycode.springboot.thymeleafcandidates.controller;

import com.tonycode.springboot.thymeleafcandidates.entity.Candidate;
import com.tonycode.springboot.thymeleafcandidates.service.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    private CandidateService candidateService;
    public CandidateController(CandidateService theCandidateservice){
        candidateService = theCandidateservice;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listCandidates(Model theModel){
        // get the candidates from the db
        List<Candidate> theCandidates = candidateService.findAll();
        // add to the spring model
        theModel.addAttribute("candidates", theCandidates);
        return "candidates/list-candidates";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create model attribute to bind form data
        Candidate theCandidate = new Candidate();
        theModel.addAttribute("candidate", theCandidate);
        return "candidates/candidate-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("candidateId") int theId, Model theModel){
        // get the employee from the service
        Candidate theCandidate = candidateService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute( "candidate",theCandidate);

        // send over to our form
        return "candidates/candidate-form";


    }
    @PostMapping("/save")
    public String saveCandidate(@ModelAttribute("candidate") Candidate theCandidate){
        // save the candidate
        candidateService.save(theCandidate);

        // use a redirect to prevent duplicate submission
        return "redirect:/candidates/list";

    }
    @GetMapping("/delete")
    public String delete(@RequestParam("candidateId") int theId){
        // delete the candidate
        candidateService.deleteById(theId);
        // redirect to the /employee/list
        return "redirect:/candidates/list";

    }



}
