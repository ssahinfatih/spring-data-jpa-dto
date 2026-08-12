package com.fatihsahin.services.impl;

import com.fatihsahin.dto.DtoStudent;
import com.fatihsahin.dto.DtoStudentIU;
import com.fatihsahin.entites.Student;
import com.fatihsahin.repository.StudentRepository;
import com.fatihsahin.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;//repository DI etmek içib autowired ile işaretliyoruz.

    //dto veri geri dönerken tüm kolonları görmemesi için kullanıyoruz.
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {//repository den kaydet özellihini çağırıyoruz.
        DtoStudent response = new DtoStudent();//db ye kaydedilen veriyi dto tipindeki responsum için kullanıyorum
        Student student = new Student();//studentIU veri tipinde gelen verimi dbye kaydetmek için kullanıyorum.
        BeanUtils.copyProperties(dtoStudentIU,student);// dtoStudent i studentıma koyala diyorum
        Student dbStudent = studentRepository.save(student);//repositoryde kopyalanan studenti veri tabanına kaydet ve dbstudentıma kaydet diyorum
        BeanUtils.copyProperties(dbStudent,response);//student tipindeki dbstudentimi dto tipindeki responsuma kaydediyorum.
        return response;//dto tipindeki responsum verideki görünmesini istediğim kolonlardaki verileri gösteriyor.
    }
    @Override
    public List<DtoStudent> getAllStudents() {//repository den tümünü getir özellihini çağırıyoruz.
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();//veritabanından listeyi çekiyoruz.
        for(Student student : studentList){//geri dönen verinin üzerinden döndüm.
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);//dönen verileri dtoStudent tipindeki dto objeme kaydettim.
            dtoStudentList.add(dto);//set ettiğimiz dto yu kaybetmemek içinde yukarda tanımladığım dtoStudentListime ekledim.
        }
        return dtoStudentList ;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {//repository den idsine göre getir özellihini çağırıyoruz.
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if(optional.isPresent()) {
            Student student = optional.get();
            BeanUtils.copyProperties(student,dto);

        }
        return dto;
    }

    @Override
    public void deleteStudentById(Integer id) {// id göre veri silme

        Optional<Student> optional = studentRepository.findById(id);//veri tabanından idye göre alıyoruz.
        if(optional.isPresent()) {//optipnal ile sunulucak bir veri varmı onu kontrol ettik.
            studentRepository.delete(optional.get());//optional.get ile gelen veriyi siliyoruz.
        }
    }

    @Override
    public DtoStudent updateStudentById(Integer id, DtoStudentIU dtoStudentIU) {//id göre veri güncelleme
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
             Student updateStudent=studentRepository.save(dbStudent);
             BeanUtils.copyProperties(updateStudent,dto);
             return dto;
        }
        return null;
    }


}
