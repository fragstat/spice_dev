package hse.project.spice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelDto {
    private String name;
    private String manufacturer;
    private Double maxI;
    private Double maxU;
    private Double maxProbU;
    private Double maxP;
    private String box;
    private String useConditions;
    private String techLink;
    private String link;
}
