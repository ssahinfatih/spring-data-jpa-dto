package com.fatihsahin.services;

import com.fatihsahin.dto.DtoStudent;
import com.fatihsahin.dto.DtoStudentIU;
import com.fatihsahin.entites.Student;

import java.util.List;


public interface IStudentService {

    //     geri dönen veri         gönderilen veri
    public DtoStudent saveStudent(DtoStudentIU dtoStudent);//veri kaydetmek işlemi.
    public List<DtoStudent> getAllStudents();// verilerin hepsini görme işlemi.
    public DtoStudent getStudentById(Integer id);// id ile veri gösterme işlemi.
    public void deleteStudentById(Integer id);// id ile veri silme
    public DtoStudent updateStudentById(Integer id, DtoStudentIU dtoStudentIU); // id ile veri güncelleme
}
