package com.fatihsahin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Ad alanı boş bırakılamaz.")// Spring Validation ile isim kısmının boş geçilemeyeceği koşulunu yazıyoruz.
    @Size(min = 3, max = 15, message = "Ad minimum 3, maksimum 15 karakter olmalıdır.")//@size string ifadelerde @max @min sayısal değerlerde kullanılır.
    private String firstName;

    @Size(min = 3,max = 15 , message = "Soyad minimum 3 maksimum 15 karakter olmalıdır.")
    private String lastName;
    private Date birthOfDate;
}
