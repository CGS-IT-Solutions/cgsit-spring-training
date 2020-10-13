package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.persistence.mongo.config.LoadDatabaseMongoDb;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping("/simplerest")
public class SimpleMongoDbRestController {

  Logger logger = LoggerFactory.getLogger(SimpleMongoDbRestController.class);

  @Autowired
  private ChatMessageMongoDbRepository chatMessageMongoDbRepository;


  @PreDestroy
  public void preDestroy() {
    logger.info("preDestroy");
  }

  @PostConstruct
  public void init() {
    logger.info("PostConstruct init ");

  }

  @GetMapping("/chatmessages")
  public @ResponseBody List<ChatMessageMongoDb> all() {
    return chatMessageMongoDbRepository.findAll();
  }


  @GetMapping("/chatmessages/{id}")
  ChatMessageMongoDb one(@PathVariable String id) {
    return chatMessageMongoDbRepository.findAll().stream().findAny().orElseThrow( () -> new RuntimeException("not found"));

    /*return chatMessageMongoDbRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("error with id not found"));
     */
  }

}
