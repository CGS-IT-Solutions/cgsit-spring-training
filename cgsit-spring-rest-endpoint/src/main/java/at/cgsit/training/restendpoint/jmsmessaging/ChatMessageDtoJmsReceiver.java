package at.cgsit.training.restendpoint.jmsmessaging;

import at.cgsit.training.common.model.ChatMessageDTO;
import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageDtoJmsReceiver {

  Logger logger = LoggerFactory.getLogger(ChatMessageDtoJmsReceiver.class);

  @JmsListener(destination = "test1" ) // , containerFactory = "myFactory")
  public void receiveMessage(String reseived) throws JsonProcessingException {
    logger.info("Received String {}", reseived);

    ChatMessageDTO chatMessageDTO = (ChatMessageDTO)new ObjectMapper().readValue(reseived, ChatMessageDTO.class);

    logger.info("Received {}", chatMessageDTO);

  }

}
