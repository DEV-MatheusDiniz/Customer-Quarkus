package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.model.Customer;
import org.acme.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Path("/api/customer")
public class CustomerController {
    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> retrieveCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @POST
    @Transactional
    public void addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerService.deleteCustomer(customer);
    }

    @PUT
    @Transactional
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
