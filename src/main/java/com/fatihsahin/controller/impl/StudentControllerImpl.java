package com.fatihsahin.controller.impl;

import com.fatihsahin.controller.IStudentController;
import com.fatihsahin.dto.DtoStudent;
import com.fatihsahin.dto.DtoStudentIU;
import com.fatihsahin.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController//controller olduğunu belirtiyoruz.
@RequestMapping("/rest/api/student")//ortak url
public class StudentControllerImpl implements IStudentController {

    @Autowired//Dİ
    private IStudentService studentService;


    @PostMapping(path = "/save")//veri kaydetmek işlemi.
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {//@RequestBody dışardan gelen json formatındaki veriyi almak için.

        return  studentService.saveStudent(dtoStudentIU );
    }

    @GetMapping(path = "/list")// verilerin hepsini görme işlemi.
    @Override
    public List<DtoStudent> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")// id ile veri gösterme işlemi.
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {

        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")//id ile veri silme
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")//id ile veri güncelleme
    @Override
    public DtoStudent updateStudentById(@PathVariable(name = "id") Integer id,@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudentById(id, dtoStudentIU);
    }
}
