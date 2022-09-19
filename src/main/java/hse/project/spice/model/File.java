package hse.project.spice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "file")
@Getter
@Setter
public class File {
    @Id
    private UUID id;
    private String fileName;
}
