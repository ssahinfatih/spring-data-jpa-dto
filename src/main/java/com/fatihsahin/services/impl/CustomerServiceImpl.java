package com.fatihsahin.services.impl;


import com.fatihsahin.dto.DtoAddress;
import com.fatihsahin.dto.DtoCustomer;
import com.fatihsahin.entites.Address;
import com.fatihsahin.entites.Customer;
import com.fatihsahin.repository.CustomerRepository;
import com.fatihsahin.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer(); // Müşteri bilgilerini taşıyacak boş bir DtoCustomer nesnesi oluşturuyoruz
        DtoAddress dtoAddress = new DtoAddress();  // Adres bilgilerini taşıyacak boş bir DtoAddress nesnesi oluşturuyoruz

        Optional<Customer> optional = customerRepository.findById(id);// Veritabanında verilen ID'ye sahip Customer'ı arıyoruz. Optional kullanmamızın sebebi Customer'ın bulunamama ihtimalidir
        if (optional.isEmpty()) {// Eğer Customer bulunamadıysa Optional boştur
            return null;
        }
        Customer customer = optional.get(); // Optional'ın içindeki gerçek Customer nesnesini alıyoruz.
        Address address = optional.get().getAddress();// Customer'ın sahip olduğu Address nesnesini alıyoruz.
        BeanUtils.copyProperties(customer, dtoCustomer); // Customer içindeki bilgileri DtoCustomer'a kopyalıyoruz.
        BeanUtils.copyProperties(address, dtoAddress); // Address içindeki bilgileri DtoAddress'a kopyalıyoruz.
        dtoCustomer.setAddress(dtoAddress); // Oluşturduğumuz DtoAddress'ı DtoCustomer'ın içine koyuyoruz.

        return dtoCustomer;// Hazırladığımız Customer DTO'sunu geri döndürüyoruz.


    }
}
