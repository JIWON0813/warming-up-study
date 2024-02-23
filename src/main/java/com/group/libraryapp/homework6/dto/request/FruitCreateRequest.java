package com.group.libraryapp.homework6.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FruitCreateRequest {
    private String name;
    private LocalDate warehousingDate;
    private long price;
}
