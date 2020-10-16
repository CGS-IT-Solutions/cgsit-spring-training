package at.cgsit.training.persistence.mongo.repository;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ChatMessageMongoDbRepositoryTest {

  @Autowired
  private ChatMessageMongoDbRepository repository;


  @Test void testMongoDB() {
    List<ChatMessageMongoDb> allMessageMongoDbs = repository.findAll();

    // assertThat(allMessageMongoDbs).isNotBlank();

  }



}
