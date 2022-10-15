package co.usar.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EntityScan(basePackages = {"co.usar.ciclo3.ciclo3.model" })
public class Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

	@Configuration public class SpringConfiguration{}

}
