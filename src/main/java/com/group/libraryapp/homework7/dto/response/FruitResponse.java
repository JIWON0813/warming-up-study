package com.group.libraryapp.homework7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FruitResponse {
    private String name;
    private long price;
    private LocalDate warehousingDate;
}
