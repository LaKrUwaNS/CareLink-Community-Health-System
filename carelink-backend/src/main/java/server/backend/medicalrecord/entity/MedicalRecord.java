package server.backend.medicalrecord.entity;


import jakarta.persistence.*;
import lombok.*;
import server.backend.doctor.entity.Doctor;
import server.backend.patient.entity.Patient;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notes;
    private String disease;
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany(mappedBy = "accessibleRecords")
    private Set<Doctor> doctors;
}
