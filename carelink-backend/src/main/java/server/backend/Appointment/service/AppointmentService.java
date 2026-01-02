package server.backend.Appointment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.backend.Appointment.entity.Appointment;
import server.backend.Appointment.repository.AppointmentRepository;
import server.backend.doctor.repository.DoctorRepository;
import server.backend.dto.request.AppointmentRequestDTO;
import server.backend.dto.response.AppointmentResponseDTO;
import server.backend.patient.repository.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    // ======================
    // CREATE APPOINTMENT
    // ======================
    public AppointmentResponseDTO create(AppointmentRequestDTO dto) {

        Appointment appointment = Appointment.builder()
                .appointmentDate(dto.getAppointmentDate())
                .reason(dto.getReason())
                .visitingType(dto.getVisitingType())
                .status("PENDING")
                .patient(patientRepository.findById(dto.getPatientId())
                        .orElseThrow(() -> new RuntimeException("Patient not found")))
                .doctor(doctorRepository.findById(dto.getDoctorId())
                        .orElseThrow(() -> new RuntimeException("Doctor not found")))
                .build();

        return mapToResponse(appointmentRepository.save(appointment));
    }

    // ======================
    // GET BY ID
    // ======================
    public AppointmentResponseDTO getById(Long id) {
        return mapToResponse(
                appointmentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Appointment not found"))
        );
    }

    // ======================
    // GET BY PATIENT
    // ======================
    public List<AppointmentResponseDTO> getByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ======================
    // GET BY DOCTOR
    // ======================
    public List<AppointmentResponseDTO> getByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ======================
    // UPDATE STATUS
    // ======================
    public void updateStatus(Long id, String status) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }

    // ======================
    // DELETE
    // ======================
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    // ======================
    // MAPPER
    // ======================
    private AppointmentResponseDTO mapToResponse(Appointment appointment) {
        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .reason(appointment.getReason())
                .visitingType(appointment.getVisitingType())
                .patientId(appointment.getPatient().getId())
                .doctorId(appointment.getDoctor().getId())
                .build();
    }
}
