package at.cgsit.training.restendpoint;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestEndpointApplication {

    public static void main(String[] args) {

      //simple startup version
      //SpringApplication.run(FirstexampleApplication.class, args);

      SpringApplication app = new SpringApplication(RestEndpointApplication.class);
      app.setBannerMode(Banner.Mode.OFF);
      app.run(args);
    }

  }
