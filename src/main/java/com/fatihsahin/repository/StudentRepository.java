package com.fatihsahin.repository;

import com.fatihsahin.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
//paramterlerden birincisi hangi sınıf üzerinde işlem yapacaksın (Student) ve primarykey olarak kullanılan kolon verilir.
{
    //Kendi özel metotlarımızı burada yazacağız.

    //HQL : sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır.
    //SQL : tablonun isni ve tablo içersindeki kolon isimleri ile sorgular yazılır.

    //@Query(value = "select * from student.student",nativeQuery = true) SQL ile sorgu.

    @Query(value = "from Student ", nativeQuery = false)//HQL ile sorgu.
    List<Student> findAllStudents();

    @Query(value = "from Student s WHERE s.id= :studentId")
    Optional<Student> findStudentById(@Param("studentId") Integer studentId);
}
