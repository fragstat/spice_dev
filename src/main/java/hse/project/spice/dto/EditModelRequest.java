package hse.project.spice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class EditModelRequest {
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
