package com.company.clinapp.controller;

import com.company.clinapp.entity.DocQualification;
import com.company.clinapp.service.DocQualificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/docQualifications")
public class DocQualificationController {

    private DocQualificationService docQualificationService;

    public DocQualificationController(DocQualificationService docQualificationService) {
        this.docQualificationService = docQualificationService;
    }

    @GetMapping
    public List<DocQualification> getAllDocQualifications() {
        return docQualificationService.getAllDocQualifications();
    }

    @GetMapping("/{docQualificationId}")
    public DocQualification getDocQualification(@PathVariable Long docQualificationId) {
        Optional<DocQualification> optional = docQualificationService
                .getDocQualification(docQualificationId);
        if (optional.isPresent())
            return optional.get();
        else return null;
    }

    @PostMapping
    public DocQualification save(@RequestBody DocQualification docQualification) {
        return docQualificationService.save(docQualification);
    }

    @DeleteMapping("/{docQualificationId}")
    public String delete(@PathVariable Long docQualificationId){
        return docQualificationService.delete(docQualificationId);
    }

    @PutMapping
    public DocQualification update(@RequestBody DocQualification docQualification){
        return docQualificationService.update(docQualification);
    }
}
