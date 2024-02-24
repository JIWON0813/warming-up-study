package com.group.libraryapp.homework7.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class FruitListByPriceRequest {
    private String option;
    private long price;
}
