package hse.project.spice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestDto {
    private String fio;
    private String org;
    private String email;
    private String phone;
    private String type;
    private String comment;
}
