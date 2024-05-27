package CourseworkWorkAutoParts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "CourseworkWorkAutoParts")
@EntityScan(basePackages = "CourseworkWorkAutoParts.models")
@EnableJpaRepositories(basePackages = "CourseworkWorkAutoParts")
@Configuration
public class AutoPartsMain {

	public static void main(String[] args) {
		SpringApplication.run(AutoPartsMain.class, args);
	}

}
