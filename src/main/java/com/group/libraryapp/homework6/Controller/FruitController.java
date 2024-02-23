package com.group.libraryapp.homework6.Controller;


import com.group.libraryapp.homework4.Service.FruitService;
import com.group.libraryapp.homework4.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework4.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework4.dto.response.AmountByNameResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2")
public class FruitController {

    private final FruitService fruitService;


    @PostMapping("/fruit")
    public void save(@RequestBody FruitCreateRequest fruitCreateRequest){
        fruitService.save(fruitCreateRequest);
    }

    @PutMapping("/fruit")
    public void updateIsSale(@RequestBody FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        fruitService.updateIsSale(fruitUpdateIsSaleRequest);
    }

    @GetMapping("/fruit/stat")
    public AmountByNameResponse amountByName(@RequestParam String name){
        var response = fruitService.amountBySale(name);
        return response;
    }

}
