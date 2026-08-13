package com.fatihsahin.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bu metot, bir List<String>'e yeni bir hata mesajı ekler.
    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }


   // MethodArgumentNotValidException oluştuğunda bu metot çalışır.Bu exception genellikle @Valid ile yapılan validation başarısız olduğunda oluşur.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errorsMap = new HashMap<>(); //  Hataları tutacağımız Map'i oluşturuyoruz.

        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {// Validation'dan gelen bütün hataları tek tek geziyoruz.

            String fieldName = ((FieldError) objError).getField();//Hatanın hangi field'a ait olduğunu buluyoruz.

            if (errorsMap.containsKey(fieldName)) {// Bu field daha önce errorsMap'in içine eklenmiş mi?
                errorsMap.put(//Eğer daha önce eklenmişse, aynı field'a ait yeni hata mesajını mevcut listenin içine ekliyoruz.
                        fieldName,
                        addMapValue(
                                errorsMap.get(fieldName),
                                objError.getDefaultMessage()
                        )
                );

            } else {

                errorsMap.put(//Eğer bu field daha önce eklenmemişse,yeni bir List oluşturup hata mesajını içine koyuyoruz.
                        fieldName,
                        addMapValue(
                                new ArrayList<>(),
                                objError.getDefaultMessage()
                        )
                );
            }
        }

        return ResponseEntity// Oluşturduğumuz hataları ApiError içine koyup, HTTP 400 Bad Request olarak kullanıcıya gönderiyoruz.
                .badRequest()
                .body(createApiError(errorsMap));
    }


    // Burada bizim özel ApiError nesnemizi oluşturuyoruz.
    private <T> ApiError<T> createApiError(T errors) {

        ApiError<T>  apiError = new ApiError<T> ();// Yeni bir ApiError nesnesi oluşturuyoruz.

        apiError.setId(UUID.randomUUID().toString());// Her hata cevabına benzersiz bir UUID veriyoruz.

        apiError.setErrorTime(new Date());// Hatanın oluştuğu zamanı kaydediyoruz.

        apiError.setErrors(errors); // Validation hatalarını ApiError'ın içine koyuyoruz.

        return apiError;// Hazırladığımız ApiError'ı geri döndürüyoruz.
    }
}
