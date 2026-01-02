package server.backend.Appointment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.backend.Appointment.service.AppointmentService;
import server.backend.dto.request.AppointmentRequestDTO;
import server.backend.dto.response.AppointmentResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // ======================
    // CREATE
    // ======================
    @PostMapping
    public AppointmentResponseDTO create(
            @RequestBody AppointmentRequestDTO request) {
        return appointmentService.create(request);
    }

    // ======================
    // GET BY ID
    // ======================
    @GetMapping("/{id}")
    public AppointmentResponseDTO getById(@PathVariable Long id) {
        return appointmentService.getById(id);
    }

    // ======================
    // GET BY PATIENT
    // ======================
    @GetMapping("/patient/{patientId}")
    public List<AppointmentResponseDTO> getByPatient(
            @PathVariable Long patientId) {
        return appointmentService.getByPatient(patientId);
    }

    // ======================
    // GET BY DOCTOR
    // ======================
    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentResponseDTO> getByDoctor(
            @PathVariable Long doctorId) {
        return appointmentService.getByDoctor(doctorId);
    }

    // ======================
    // UPDATE STATUS
    // ======================
    @PatchMapping("/{id}/status")
    public void updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        appointmentService.updateStatus(id, status);
    }

    // ======================
    // DELETE
    // ======================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        appointmentService.delete(id);
    }
}