package hse.project.spice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConfigurationProperties(prefix = "minio")
@Getter
@Setter
@Primary
public class MinioConfig {
    private String url;
    private String user;
    private String password;
    private String bucket;
}
