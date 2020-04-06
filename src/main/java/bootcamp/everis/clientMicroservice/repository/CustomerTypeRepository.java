package bootcamp.everis.clientMicroservice.repository;

import bootcamp.everis.clientMicroservice.document.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends ReactiveMongoRepository<CustomerType,Long> {
}
