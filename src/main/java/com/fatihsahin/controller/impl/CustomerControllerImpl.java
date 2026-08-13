package com.fatihsahin.controller.impl;

import com.fatihsahin.controller.ICustomerController;
import com.fatihsahin.dto.DtoCustomer;
import com.fatihsahin.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }
}
