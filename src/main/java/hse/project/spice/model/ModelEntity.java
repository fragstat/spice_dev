package hse.project.spice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "model")
@Getter
@Setter
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    @Column(name = "max_i")
    private Double maxI;
    @Column(name = "max_u")
    private Double maxU;
    @Column(name = "max_prob_u")
    private Double maxProbU;
    @Column(name = "max_p")
    private Double maxP;
    private String box;
    private String useConditions;
    private String techLink;
    private String link;
}
