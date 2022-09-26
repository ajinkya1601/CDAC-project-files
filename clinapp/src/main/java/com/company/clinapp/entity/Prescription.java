package com.company.clinapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="prescription")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prescriptionDate;
    private String diagnosis;
    private short weight;
    private String bp;
    private Long patientId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescriptionId")
    private List<Product> products;
}
