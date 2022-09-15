package com.company.clinapp.service;

import com.company.clinapp.dao.DocQualificationRepository;
import com.company.clinapp.entity.DocQualification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocQualificationService {

    private DocQualificationRepository docQualificationRepository;

    public DocQualificationService(DocQualificationRepository docQualificationRepository) {
        this.docQualificationRepository = docQualificationRepository;
    }

    public List<DocQualification> getAllDocQualifications(){
        return docQualificationRepository.findAll();
    }


    public Optional<DocQualification> getDocQualification(Long id){
        return docQualificationRepository.findById(id);
    }

    public DocQualification save(DocQualification docQualification){
        return docQualificationRepository.save(docQualification);
    }

    public String delete (Long id){
        if(getDocQualification(id).isPresent()){
            docQualificationRepository.deleteById(id);
            return "Doctor Qualification with id " + id + " is deleted!";
        } else
            return "Doctor Qualification with id " + id + " not found";
        }

    public DocQualification update(DocQualification docQualification){
        return docQualificationRepository.save(docQualification);
    }

}
