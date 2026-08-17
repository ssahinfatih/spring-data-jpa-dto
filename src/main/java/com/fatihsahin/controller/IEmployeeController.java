package com.fatihsahin.controller;

import com.fatihsahin.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {

    public List<DtoEmployee> findAllEmployees();
}
