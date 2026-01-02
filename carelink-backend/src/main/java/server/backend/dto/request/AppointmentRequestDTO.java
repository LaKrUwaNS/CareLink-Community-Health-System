package server.backend.dto.request;

import lombok.Data;
import server.backend.utils.VisitingType;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {

    private LocalDateTime appointmentDate;
    private String reason;
    private VisitingType visitingType;

    private Long patientId;
    private Long doctorId;
}
