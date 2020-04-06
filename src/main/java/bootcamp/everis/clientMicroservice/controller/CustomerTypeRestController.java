package bootcamp.everis.clientMicroservice.controller;

import bootcamp.everis.clientMicroservice.document.CustomerType;
import bootcamp.everis.clientMicroservice.service.CustomerTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/CustomerType")
public class CustomerTypeRestController {

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping(value = "/allTypeC")
    @ApiOperation(value = "Find all types of clients",notes = "It shows me the information of all types of clients")
    public Flux<CustomerType> getAllTypeCus(){
        return this.customerTypeService.getCustomerType();
    }

    @PostMapping("/saveTypeC")
    @ApiOperation(value = "Registered types of clients",notes = "Register the types of clients")
    public Mono<CustomerType> saveTypeCus(@RequestBody CustomerType saveTC){
        return this.customerTypeService.saveCustomerType(saveTC);
    }

    @DeleteMapping("/deleteTypeC/{idCT}")
    @ApiOperation(value = "Delete types of clients by id",notes = "Client types are searched by id and removed")
    public Mono<ResponseEntity<CustomerType>> deleteTypeCus(@PathVariable("idCT") Long idCT){
        return this.customerTypeService.deleteCustomerType(idCT)
                .flatMap(cusDelTypeCus-> Mono.just(ResponseEntity.ok(cusDelTypeCus)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/updateTypeC/{idCT}")
    @ApiOperation(value = "Update types of clients by id",notes = "The types of clients are searched by id and modified.")
    public Mono<ResponseEntity<CustomerType>> updateTypeCus(@PathVariable("idCT") Long idCT,@RequestBody CustomerType delTypeCus){
        return this.customerTypeService.updateCustomerType(idCT, delTypeCus)
                .flatMap(CusType-> Mono.just(ResponseEntity.ok(CusType)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
