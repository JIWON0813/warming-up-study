package com.group.libraryapp.homework6.Controller;


import com.group.libraryapp.homework6.Service.FruitServiceV6;
import com.group.libraryapp.homework6.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework6.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework6.dto.response.AmountByNameResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v6")
public class FruitControllerV6 {

    private final FruitServiceV6 fruitServiceV6;


    @PostMapping("/fruit")
    public void save(@RequestBody FruitCreateRequest fruitCreateRequest){
        fruitServiceV6.save(fruitCreateRequest);
    }

    @PutMapping("/fruit")
    public void updateIsSale(@RequestBody FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        fruitServiceV6.updateIsSale(fruitUpdateIsSaleRequest);
    }

    @GetMapping("/fruit/stat")
    public AmountByNameResponse amountByName(@RequestParam String name){
        var response = fruitServiceV6.amountBySale(name);
        return response;
    }

}
