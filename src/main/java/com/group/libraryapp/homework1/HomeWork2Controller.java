package com.group.libraryapp.homework1;

import com.group.libraryapp.homework1.request.CalculatorRequest;
import com.group.libraryapp.homework1.request.SumRequest;
import com.group.libraryapp.homework1.response.CalculatorResponse;
import com.group.libraryapp.homework1.response.DayResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class HomeWork2Controller {

    @GetMapping("/calc")
    public CalculatorResponse calculate(CalculatorRequest calculatorRequest){
        int add = calculatorRequest.getNum1() + calculatorRequest.getNum2();
        int minus = calculatorRequest.getNum1() - calculatorRequest.getNum2();
        int multiply = calculatorRequest.getNum1() * calculatorRequest.getNum2();

        CalculatorResponse calculatorResponse = new CalculatorResponse(add, minus, multiply);

        return calculatorResponse;
    }

    @GetMapping("/day-of-the-week")
    public DayResponse dauOfWeek(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date ){
        DayResponse dayResponse = new DayResponse(date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US));

        return dayResponse;
    }

    @PostMapping("/sum")
    public int sum(@RequestBody SumRequest sumRequest){
        var requestList = sumRequest.getNumbers();
        Integer response = 0;

        for(int i = 0; i < requestList.size(); i++){
            response += requestList.get(i);
        }

        return response;
    }
}
