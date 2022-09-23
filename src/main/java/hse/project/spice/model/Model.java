package hse.project.spice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    @Column(name = "max_i")
    private Double maxI = .0d;
    @Column(name = "max_u")
    private Double maxU = .0d;
    @Column(name = "max_prob_u")
    private Double maxProbU = .0d;
    @Column(name = "max_p")
    private Double maxP = .0d;
    private String box;
    private String useConditions;
    private String techLink;
    private String link;
}
