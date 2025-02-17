package br.com.agi.domain.port.out;

import br.com.agi.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Optional<Customer> findByCpf(String cpf);
    List<Customer> findAll();
    void delete(String id);
}
