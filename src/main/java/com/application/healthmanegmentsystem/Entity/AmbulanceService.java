package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ambulanceService")
public class AmbulanceService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aumbulance_id")
    private Long id;
    private String name;
    private String phoneNumber;
    private String Address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date data;
    private Boolean status;
}
