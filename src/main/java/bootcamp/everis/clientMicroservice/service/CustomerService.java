package bootcamp.everis.clientMicroservice.service;

import bootcamp.everis.clientMicroservice.document.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {
    public Flux<Customer> getCustomer();
//  public Mono<Customer> findByIdCustomer(Long id);
    public Mono<Customer> saveCustomer(Customer cusS);
    public Mono<Customer> updateCustomer(Long id, Customer cusS);
    public Mono<Customer> deleteCustomer(Long id);
}
