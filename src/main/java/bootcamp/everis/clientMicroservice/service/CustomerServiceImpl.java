package bootcamp.everis.clientMicroservice.service;

import bootcamp.everis.clientMicroservice.document.Customer;
import bootcamp.everis.clientMicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getCustomer() {
        return this.customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findByIdCustomer(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> saveCustomer(Customer cusS) {
        return this.customerRepository.save(cusS);
    }

    @Override
    public Mono<Customer> updateCustomer(Long id, Customer cusS) {
        return this.customerRepository.findById(id)
                .flatMap(customeri -> {
                    cusS.setId(id);
                    return saveCustomer(cusS);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Customer> deleteCustomer(Long id) {
        return this.customerRepository
                .findById(id)
                .flatMap(C ->
                        this.customerRepository.deleteById(C.getId()).thenReturn(C));
    }
}
