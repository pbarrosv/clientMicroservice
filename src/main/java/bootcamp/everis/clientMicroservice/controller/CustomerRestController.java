package bootcamp.everis.clientMicroservice.controller;

import bootcamp.everis.clientMicroservice.document.Customer;
import bootcamp.everis.clientMicroservice.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/Customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/allCustomer")
    @ApiOperation(value = "Find all customers ",notes = "It shows me the information of all the clients")
    public Flux<Customer> getAll() {
        return customerService.getCustomer();
    }

    @PostMapping("/saveCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registered customer",notes = "Register customer information")
    public Mono<Customer> save(@Valid @RequestBody Customer saveCus) {
        return this.customerService.saveCustomer(saveCus);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @ApiOperation(value = "Delete customer by id",notes = "Customers are searched by id and removed")
    public Mono<ResponseEntity<Customer>> delete(@PathVariable("id") Long id) {
        return this.customerService.deleteCustomer(id)
                .flatMap(cusDel -> Mono.just(ResponseEntity.ok(cusDel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/updateCustomer/{id}")
    @ApiOperation(value = "Update customer by id",notes = "Customers are searched by id and modified")
    public Mono<ResponseEntity<Customer>> update(@PathVariable("id") Long id, @RequestBody Customer deleCus) {
        return this.customerService.updateCustomer(id, deleCus)
                .flatMap(customeri -> Mono.just(ResponseEntity.ok(customeri)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
