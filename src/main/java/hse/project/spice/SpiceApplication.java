package hse.project.spice;

import hse.project.spice.config.MinioConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MinioConfig.class)
public class SpiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiceApplication.class, args);
	}

}
