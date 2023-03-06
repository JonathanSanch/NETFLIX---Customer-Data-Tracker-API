package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldAddCustomer() {

//         Arrange
        Customer customer = new Customer();
        customer.setFirstName("Jonathan");
        customer.setLastName("Sanchez");
        customer.setAddress1("123 Lane");
        customer.setCity("Miami");
        customer.setId(10);
        customer.setEmail("123@gmail.com");
        customer.setAddress2("Apt 3");
        customer.setPhoneNum("111 222 3456");
        customer.setPostCode("123");
        customer.setCountry("USA");
        customer.setState("Florida");

//        Act
        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

//        Assert
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Jonathan");
        customer.setLastName("Sanchez");
        customer.setAddress1("123 Lane");
        customer.setCity("Miami");
        customer.setId(10);
        customer.setEmail("123@gmail.com");
        customer.setAddress2("Apt 3");
        customer.setPhoneNum("111 222 3456");
        customer.setPostCode("123");
        customer.setCountry("USA");
        customer.setState("Florida");

        customer = customerRepository.save(customer);

        customer.setFirstName("Joseph");

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Jonathan");
        customer.setLastName("Sanchez");
        customer.setAddress1("123 Lane");
        customer.setCity("Miami");
        customer.setId(10);
        customer.setEmail("123@gmail.com");
        customer.setAddress2("Apt 3");
        customer.setPhoneNum("111 222 3456");
        customer.setPostCode("123");
        customer.setCountry("USA");
        customer.setState("Florida");

        customer = customerRepository.save(customer);

        customerRepository.deleteById(customer.getId());

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

//        Assert (false)
        assertFalse(customer1.isPresent());
    }



    @Test
    public void shouldFindCustomerByID() {

        Customer customer = new Customer();
        customer.setFirstName("Jonathan");
        customer.setLastName("Sanchez");
        customer.setAddress1("123 Lane");
        customer.setCity("Miami");
        customer.setId(10);
        customer.setEmail("123@gmail.com");
        customer.setAddress2("Apt 3");
        customer.setPhoneNum("111 222 3456");
        customer.setPostCode("123");
        customer.setCountry("USA");
        customer.setState("Florida");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);

    }

    @Test
    public void shouldFindACustomerByState() {
        Customer customer = new Customer();
        customer.setFirstName("Jonathan");
        customer.setLastName("Sanchez");
        customer.setAddress1("123 Lane");
        customer.setCity("Miami");
        customer.setId(10);
        customer.setEmail("123@gmail.com");
        customer.setAddress2("Apt 3");
        customer.setPhoneNum("111 222 3456");
        customer.setPostCode("123");
        customer.setCountry("USA");
        customer.setState("Florida");


        customer = customerRepository.save(customer);

        List<Customer> customers = customerRepository.findAllCustomersByState("Florida");

//       Test the first index of the List with the actual Customer
        assertEquals(customers.get(0), customer);
    }

}