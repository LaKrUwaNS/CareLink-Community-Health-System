package server.backend.Appointment.entity;


import jakarta.persistence.*;
import lombok.*;
import server.backend.doctor.entity.Doctor;
import server.backend.patient.entity.Patient;
import server.backend.utils.VisitingType;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    private String status;

    private String reason;

    private VisitingType visitingType;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
