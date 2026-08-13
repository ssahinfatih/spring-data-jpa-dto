package com.fatihsahin.services;


import com.fatihsahin.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}

