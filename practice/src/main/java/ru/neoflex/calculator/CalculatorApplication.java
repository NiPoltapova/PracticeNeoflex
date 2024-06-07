package ru.neoflex.calculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Practice for Neoflex - online calculator",
                version = "1.0.0",
                description = "This project was created by Domenika Poltapova, group 32919/2",
                contact = @Contact(
                        name = "Domenika Poltapova",
                        email = "nipoltapova@mail.ru"
                )
        )
)

public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

}
