package br.com.agi.infrastructure.controller;

import br.com.agi.application.service.CustomerService;
import br.com.agi.domain.model.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> register(@NotNull @RequestBody Customer customer) {

        //idempotency
        Optional<Customer> existCustomer = service.getCustomerByCpf(customer.getCpf());
        return existCustomer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).body(service.registerCustomer(customer)));
    }

    @PutMapping
    public ResponseEntity<Customer> update(@NotNull @RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customer));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Customer> getByCpf(@PathVariable("cpf") String cpf) {
        Optional<Customer> customer = service.getCustomerByCpf(cpf);
        return customer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
