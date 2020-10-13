package at.cgsit.training.restendpoint.rest;

import at.cgsit.training.common.model.ChatMessageDTO;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import at.cgsit.training.persistence.mongo.repository.ChatMessageMongoDbRepository;
import at.cgsit.training.restendpoint.jmsmessaging.ChatMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping("/jms")
public class SimpleJmsChatMesasageRestController {

  Logger logger = LoggerFactory.getLogger(SimpleJmsChatMesasageRestController.class);

  @Autowired
  private ChatMessageMongoDbRepository chatMessageMongoDbRepository;

  @Autowired
  ChatMessageSender chatMessageSender;

  @PreDestroy
  public void preDestroy() {
    logger.info("preDestroy");
  }

  @PostConstruct
  public void init() {
    logger.info("PostConstruct init ");

  }

  @GetMapping("/sendmessage/{id}")
  ChatMessageMongoDb one(@PathVariable String id) {

    ChatMessageMongoDb chatMessage = chatMessageMongoDbRepository.findAll().stream().findAny().orElseThrow(() -> new RuntimeException("not found"));

    ChatMessageDTO cmDTO = new ChatMessageDTO();
    cmDTO.setId(chatMessage.getId());
    cmDTO.setSender(chatMessage.getSender());
    cmDTO.setRecipient(chatMessage.getRecipient());
    cmDTO.setContent(chatMessage.getContent());

    chatMessageSender.send(cmDTO);

    return chatMessage;

    /*return chatMessageMongoDbRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("error with id not found"));
     */
  }

}
