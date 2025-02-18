package br.com.agi.application.service;

import br.com.agi.domain.model.Customer;
import br.com.agi.application.port.in.CustomerUseCase;
import br.com.agi.application.port.out.CustomerRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CustomerUseCase {

    @Autowired
    private final CustomerRepositoryPort repository;

    public CustomerService(CustomerRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public Optional<Customer> getCustomerByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public void deleteCustomer(String id) {
        repository.delete(id);
    }
}
