package pet.by.ishangulyev.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication(scanBasePackages = "pet.by.ishangulyev")
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name","application-user-service");
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
