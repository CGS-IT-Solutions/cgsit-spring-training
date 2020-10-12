package at.cgsit.training.persistence.mongo.repository;

import at.cgsit.training.persistence.mongo.model.ChatMessageMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageMongoDbRepository extends MongoRepository<ChatMessageMongoDb, String> {

    public ChatMessageMongoDb findBySender(String sender);

  }
