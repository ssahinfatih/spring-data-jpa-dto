package com.fatihsahin.services.impl;

import com.fatihsahin.dto.DtoDepartment;
import com.fatihsahin.dto.DtoEmployee;
import com.fatihsahin.entites.Department;
import com.fatihsahin.entites.Employee;
import com.fatihsahin.repository.EmployeeRepository;
import com.fatihsahin.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> findAllEmployees() {

        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();
   /*     if (employeeList != null && !employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee, dtoEmployee);

                dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),employee.getDepartment().getDepartmentName()));

                dtoEmployeeList.add(dtoEmployee);

            }

        }
        return dtoEmployeeList;*/
        for (Employee employee : employeeList) {

            DtoEmployee dtoEmployee = new DtoEmployee();

            BeanUtils.copyProperties(employee, dtoEmployee);

            Department department = employee.getDepartment();

            if (department != null) {

                DtoDepartment dtoDepartment = new DtoDepartment();

                BeanUtils.copyProperties(department, dtoDepartment);

                dtoEmployee.setDepartment(dtoDepartment);
            }

            dtoEmployeeList.add(dtoEmployee);
        }

        return dtoEmployeeList;


    }
}
