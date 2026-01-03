package server.backend.patient.entity;

import server.backend.Appointment.entity.Appointment;
import server.backend.medicalrecord.entity.MedicalRecord;
import server.backend.security.user.AppUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private AppUser user;

    private String contact;
    private String gender;
    private LocalDate dob;

    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
