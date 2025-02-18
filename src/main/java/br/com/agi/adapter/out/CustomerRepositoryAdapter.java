package br.com.agi.adapter.out;

import br.com.agi.domain.model.Customer;
import br.com.agi.application.port.out.CustomerRepositoryPort;
import br.com.agi.adapter.out.repository.MongoCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {

    @Autowired
    private final MongoCustomerRepository repository;

    public CustomerRepositoryAdapter(MongoCustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
