package br.com.agi.application.service;

import br.com.agi.domain.model.Customer;
import br.com.agi.domain.port.out.CustomerRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepositoryPort repository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("123456789","12345678900", "João Silva", "1990-01-01", "999999999", "Rua A, 100");
    }

    @Test
    void shouldCreateCustomerSuccessfully() {
        when(repository.save(any())).thenReturn(customer);

        Customer savedCustomer = customerService.registerCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals("12345678900", savedCustomer.getCpf());
        verify(repository, times(1)).save(customer);
    }

    @Test
    void shouldFindCustomerByCpf() {
        when(repository.findByCpf("12345678900")).thenReturn(Optional.of(customer));

        Optional<Customer> foundCustomer = customerService.getCustomerByCpf("12345678900");

        assertTrue(foundCustomer.isPresent());
        assertEquals("João Silva", foundCustomer.get().getName());
    }

    @Test
    void shouldUpdateCustomerSuccessfully() {
        when(repository.update(any())).thenReturn(customer);

        Customer updatedCustomer = new Customer("123456789","12345678900", "Maria Souza", "1990-01-01", "999999999", "Rua B, 200");

        Customer result = customerService.updateCustomer(updatedCustomer);

        assertNotNull(result);
        assertEquals("João Silva", result.getName());
        verify(repository, times(1)).update(any());
    }

    @Test
    void shouldDeleteCustomerSuccessfully() {
        doNothing().when(repository).delete("12345678900");

        customerService.deleteCustomer("12345678900");

        verify(repository, times(1)).delete("12345678900");
    }
}

