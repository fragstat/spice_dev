package hse.project.spice.service.impl;

import hse.project.spice.config.MinioConfig;
import hse.project.spice.model.File;
import hse.project.spice.repository.FileRepository;
import hse.project.spice.service.MinioService;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioConfig minioProperties;
    private final FileRepository fileRepository;
    private MinioClient MINIO_CLIENT;

    @PostConstruct
    private void createClient() {
        MINIO_CLIENT = MinioClient.builder()
            .endpoint(minioProperties.getUrl())
            .credentials(minioProperties.getUser(), minioProperties.getPassword())
            .build();
        try {
            if (!MINIO_CLIENT.bucketExists(BucketExistsArgs.builder()
                    .bucket(minioProperties.getBucket())
                    .build())) {
                MINIO_CLIENT.makeBucket(MakeBucketArgs.builder()
                        .bucket(minioProperties.getBucket())
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public UUID uploadFile(MultipartFile file) {
        try {
            File fileEntity = new File();
            fileEntity.setFileName(fileEntity.getFileName());
            fileEntity.setId(UUID.randomUUID());
            fileEntity = fileRepository.save(fileEntity);
            MINIO_CLIENT.putObject(PutObjectArgs.builder()
                    .bucket(minioProperties.getBucket())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .object(fileEntity.getId().toString())
                    .contentType(file.getContentType())
                    .build());
            return fileEntity.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public ByteArrayInputStream getFile(UUID id) {
        try {
            GetObjectResponse response = MINIO_CLIENT.getObject(GetObjectArgs.builder()
                            .bucket(minioProperties.getBucket())
                            .object(id.toString())
                    .build());
            return new ByteArrayInputStream(response.readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
