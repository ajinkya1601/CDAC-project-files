package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "clinic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clinicName;
    private String clinicEmail;
    private String clinicAddress;
    private String clinicPhone;
    private String morningTime;
    private String afternoonTime;
    private String eveningTime;
//    private Blob image;
    private String registrationDate;
    private String userUsername;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clinicId")
    private List<Department> departments;

}
 