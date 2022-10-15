package pet.by.ishangulyev.videoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "pet.by.ishangulyev")
@EnableEurekaClient
public class VideoServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name","application-video-service");
        SpringApplication.run(VideoServiceApplication.class, args);
    }

}
