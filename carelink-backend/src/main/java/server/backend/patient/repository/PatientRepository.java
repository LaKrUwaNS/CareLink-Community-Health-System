package server.backend.patient.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import server.backend.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
