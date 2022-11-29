package com.application.healthmanegmentsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "freeCheckupService")
public class FreeCheckupService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freeCheckup_id")
    private Long id;
    private String name;
    private String phoneNumber;
    @Email
    private String email;
    private String issue;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private boolean status;
}
