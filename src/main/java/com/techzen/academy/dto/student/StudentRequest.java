package com.techzen.academy.dto.student;

import com.techzen.academy.dto.clazz.ClazzRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequest {
    String name;
    Double score;

    ClazzRequest clazz;
}
