package bootcamp.everis.clientMicroservice.service;

import bootcamp.everis.clientMicroservice.document.CustomerType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerTypeService {
    public Flux<CustomerType> getCustomerType();
    public Mono<CustomerType> saveCustomerType(CustomerType CusTS);
    public Mono<CustomerType> updateCustomerType(Long idCT,CustomerType CusTS);
    public Mono<CustomerType> deleteCustomerType(Long idCT);
}
