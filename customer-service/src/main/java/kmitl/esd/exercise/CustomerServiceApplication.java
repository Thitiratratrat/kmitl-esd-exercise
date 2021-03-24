package kmitl.esd.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CustomerServiceApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8000"));
        app.run(args);
    }

}

