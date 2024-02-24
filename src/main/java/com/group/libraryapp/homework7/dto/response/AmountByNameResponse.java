package com.group.libraryapp.homework7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AmountByNameResponse {
    private long salesAmount;
    private long notsalesAmount;
}
