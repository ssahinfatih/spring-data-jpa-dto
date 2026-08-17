package com.fatihsahin.services;

import com.fatihsahin.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {

    public List<DtoEmployee> findAllEmployees();
}
