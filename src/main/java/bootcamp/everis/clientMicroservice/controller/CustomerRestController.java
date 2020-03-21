package bootcamp.everis.clientMicroservice.controller;

import bootcamp.everis.clientMicroservice.document.Customer;
import bootcamp.everis.clientMicroservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/all")
    public Flux<Customer> getAll() {
        return customerService.getCustomer();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> save(@RequestBody Customer saveCus) {
        return this.customerService.saveCustomer(saveCus);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Customer>> delete(@PathVariable("id") Long id) {
        return this.customerService.deleteCustomer(id)
                .flatMap(cusDel -> Mono.just(ResponseEntity.ok(cusDel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Customer>> update(@PathVariable("id") Long id, @RequestBody Customer deleCus) {
        return this.customerService.updateCustomer(id, deleCus)
                .flatMap(customeri -> Mono.just(ResponseEntity.ok(customeri)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
