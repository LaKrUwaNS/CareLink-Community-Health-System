package server.backend.article.entity;


import jakarta.persistence.*;
import lombok.*;
import server.backend.doctor.entity.Doctor;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String category;
    private String verifiedBy;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
