package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CustomerRepository customerRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

//    Don't have to have anything special since it's autowired
    @Before
    public void setUp() throws Exception{}


    @Test
    void getCustomerById() throws Exception {

        mockMvc.perform(get("/customers/10"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void addCustomer() throws Exception {
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

        String input = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post("/cusotomer").content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
   public void updateCustomer() throws Exception {
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

        String input = objectMapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer")
                .content(input)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());


    }

    @Test
    public void deleteArtist() throws Exception{

        mockMvc.perform(delete("/customers/10"))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void getCustomersByState() throws Exception {

        mockMvc.perform(get("customer/state/Florida"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}