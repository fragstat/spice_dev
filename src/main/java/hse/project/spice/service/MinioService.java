package hse.project.spice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public interface MinioService {

    UUID uploadFile(MultipartFile file);

    ByteArrayInputStream getFile(UUID id);
}
