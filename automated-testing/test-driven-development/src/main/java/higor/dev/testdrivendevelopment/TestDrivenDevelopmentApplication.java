package higor.dev.testdrivendevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "higor.dev.testdrivendevelopment")
public class TestDrivenDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDrivenDevelopmentApplication.class, args);
	}

}
