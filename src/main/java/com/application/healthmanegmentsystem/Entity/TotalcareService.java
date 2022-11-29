package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "totalcareService")
public class TotalcareService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "totalCare_id")
    private Long id;
    private String name;
    private String phoneNumber;
    private int familySize;
    private Boolean status;
}
