package com.fatihsahin.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity // bunun bir tablo olduğunu belirtir.
@Table(name ="student")
@Data // Getter ve Setter işlemlerini yapar.
@NoArgsConstructor // boş constructor oluşturur.
@AllArgsConstructor // bütün değişkenleri isteyen constructor.
public class Student {

    @Id // benzersiz kimlikle işaretlemek.
    @Column(name ="id")//tablonun bir stunu ve adı "id" olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Bu ID'yi ben vermeyeceğim, veritabanı kendisi otomatik versin.
    private Integer id;

    @Column(name="first_name",nullable=false,length=100)//tablonun bir stunu ve adı "first_name",boş değer alamaz uzunluğu 100 karakteri geçemez olduğunu belirtir.
    private String firstName;

    @Column(name="last_name",nullable=false,length=100)//tablonun bir stunu ve adı "last_name",boş değer alamaz uzunluğu 100 karakteri geçemez olduğunu belirtir.
    private String lastName;

    @DateTimeFormat(iso =  DateTimeFormat.ISO.DATE)//tarih formatını belirtir.
    @Column(name="birth_of_date",nullable = true)//tablonun bir stunu ve adı "birth_of_date, boş değer olabilir olduğunu belirtir.
    private Date birthOfDate ;


}
