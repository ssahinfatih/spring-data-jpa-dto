package com.fatihsahin.controller;
import com.fatihsahin.dto.DtoStudent;
import com.fatihsahin.dto.DtoStudentIU;
import com.fatihsahin.entites.Student;
import java.util.List;


public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);//veri kaydetmek işlemi.
    public List<DtoStudent> getAllStudents();// verilerin hepsini görme işlemi.
    public DtoStudent getStudentById(Integer id);// id ile veri gösterme işlemi.
    public void deleteStudentById(Integer id);//id ile veri silme işlmei.
    public DtoStudent updateStudentById(Integer id, DtoStudentIU updateStudent);
}
