package com.group.libraryapp.homework1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SumRequest {
    private ArrayList<Integer> numbers;
}
