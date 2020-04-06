package bootcamp.everis.clientMicroservice.service;

import bootcamp.everis.clientMicroservice.document.CustomerType;
import bootcamp.everis.clientMicroservice.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerTypeServiceImp implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Flux<CustomerType> getCustomerType() {
        return this.customerTypeRepository.findAll();
    }

    @Override
    public Mono<CustomerType> saveCustomerType(CustomerType CusTS) {
        return this.customerTypeRepository.save(CusTS);
    }

    @Override
    public Mono<CustomerType> updateCustomerType(Long idCT, CustomerType CusTS) {
        return this.customerTypeRepository.findById(idCT)
                .flatMap(customerTC -> {
                    CusTS.setIdCT(idCT);
                    return  saveCustomerType(CusTS);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<CustomerType> deleteCustomerType(Long idCT) {
        return this.customerTypeRepository
                .findById(idCT)
                .flatMap(CTC ->
                        this.customerTypeRepository.deleteById(CTC.getIdCT()).thenReturn(CTC));
    }
}
