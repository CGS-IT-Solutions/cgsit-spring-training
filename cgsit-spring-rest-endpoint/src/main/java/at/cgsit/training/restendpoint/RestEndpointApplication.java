package at.cgsit.training.restendpoint;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// @ComponentScan("at.cgsit.training.persistence.mongo.repository")
/*@ComponentScan({
    "at.cgsit.training.persistence.mongo.model",
    "at.cgsit.training.persistence.mongo.config",
    "at.cgsit.training.persistence.mongo.repository",
    "at.cgsit.training.restendpoint"})

@ComponentScan(basePackages={
    "at.cgsit",
    "at.cgsit.training.restendpoint"})

@ComponentScan("at.cgsit")
    */


// @EnableAutoConfiguration
// @EnableJpaRepositories(basePackages="com.sivalabs.jcart")
// @EntityScan(basePackages="at.cgsit")

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="at.cgsit")
@EnableMongoRepositories(basePackages="at.cgsit.training.persistence.mongo.repository")
public class RestEndpointApplication {

    public static void main(String[] args) {

      //simple startup version
      //SpringApplication.run(FirstexampleApplication.class, args);

      SpringApplication app = new SpringApplication(RestEndpointApplication.class);
      app.setBannerMode(Banner.Mode.LOG);
      app.run(args);
    }

  }
