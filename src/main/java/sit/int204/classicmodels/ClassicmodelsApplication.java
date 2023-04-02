package sit.int204.classicmodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sit.int204.classicmodels.properties.FileStorageProperties;
import sit.int204.classicmodels.properties.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class, JwtProperties.class
})
public class ClassicmodelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassicmodelsApplication.class, args);
	}

}
