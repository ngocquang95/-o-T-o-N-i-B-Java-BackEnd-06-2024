package com.techzen.academy.dto.student;

import com.techzen.academy.dto.clazz.ClazzRequest;
import com.techzen.academy.validator.DobConstraint;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    //    @NotBlank(message = "Ten khong dc de trong")
//    @Pattern(regexp = "[a-zA-ZÀ-ỹ ]+", message = "Ten khong dung quy tac")
//    @Size(max = 30, message = "Ten chi chua toi da 30 ky tu")
            /*
            +: 1 hoac n lan
            *: % 0 hoac n lan
            ?: 1 hoac 0 lan
             */
    // @NotNull(message = "Ten khog dc null")
    @NotEmpty(message = "Khong dc rong")
    String name;

    @NotNull(message = "Diem phai nhap")
    String score;

    @DobConstraint(min = 18, message = "Ban tuoi")
    LocalDate dob;

    ClazzRequest clazz;
}
