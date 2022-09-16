package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "doc_qualification")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String graduation;
    private String graduationCompletionYear;
    private String postGrad;
    private String postGradCompletionYear;
    private Long medicalRegistrationNo;
    private String additionalQualification;
    private String additionalQualificationCompletionYear;
    private short experience;
    private Long employeeId;

}
