package hse.project.spice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String org;
    private String email;
    private String phone;
    private String type;
    private String comment;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
