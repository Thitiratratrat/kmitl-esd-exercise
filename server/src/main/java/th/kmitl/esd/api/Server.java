package th.kmitl.esd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Server.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8000"));
        app.run(args);
    }

}
