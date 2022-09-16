package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name="patient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private short age;
    private String mobile;
    private String email;
    private String address;
    private Long employeeId;
    private Long deptId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId")
    private List<Prescription> prescriptions;
}
