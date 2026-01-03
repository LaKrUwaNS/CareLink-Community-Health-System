package server.backend.dto.response;

import lombok.Builder;
import lombok.Data;
import server.backend.utils.VisitingType;

import java.time.LocalDateTime;

@Data
@Builder
public class AppointmentResponseDTO {

    private Long id;
    private LocalDateTime appointmentDate;
    private String status;
    private String reason;
    private VisitingType visitingType;

    private Long patientId;
    private Long doctorId;
}