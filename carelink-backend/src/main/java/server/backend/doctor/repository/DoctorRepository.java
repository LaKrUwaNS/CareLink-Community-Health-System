package server.backend.doctor.repository;

import org.springframework.data.repository.CrudRepository;
import server.backend.doctor.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
