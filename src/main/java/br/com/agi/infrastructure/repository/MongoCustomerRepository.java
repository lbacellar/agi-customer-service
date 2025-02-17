package br.com.agi.infrastructure.repository;

import br.com.agi.domain.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoCustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCpf(String cpf);
}