package com.fatihsahin.services.impl;

import com.fatihsahin.dto.DtoAddress;
import com.fatihsahin.dto.DtoCustomer;
import com.fatihsahin.entites.Address;
import com.fatihsahin.repository.AddressRepository;
import com.fatihsahin.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());
        dtoAddress.setCustomer(dtoCustomer);


        return dtoAddress;
    }
}
