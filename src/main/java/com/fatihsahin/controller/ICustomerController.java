package com.fatihsahin.controller;

import com.fatihsahin.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);
}