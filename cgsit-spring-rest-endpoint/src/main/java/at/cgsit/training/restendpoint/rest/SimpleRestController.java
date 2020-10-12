package at.cgsit.training.restendpoint.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simplerest")
public class SimpleRestController {

  Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

  @GetMapping("/properties/{property}")
  String getProperty(@PathVariable String property) {
    logger.info("getProperty /properties called with value {}", property);
    logger.info("Working Directory = " + System.getProperty("user.dir"));
    return "success";
  }


}
