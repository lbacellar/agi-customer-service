package br.com.agi.domain.port.in;

import br.com.agi.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerUseCase {
    Customer registerCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Optional<Customer> getCustomerByCpf(String cpf);
    List<Customer> getAllCustomers();
    void deleteCustomer(String cpf);
}
