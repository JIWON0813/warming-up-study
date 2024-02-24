package com.group.libraryapp.homework7.Controller;


import com.group.libraryapp.homework7.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework7.dto.request.FruitListByPriceRequest;
import com.group.libraryapp.homework7.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework7.dto.response.AmountByNameResponse;
import com.group.libraryapp.homework7.Service.FruitServiceV7;
import com.group.libraryapp.homework7.dto.response.CountResponse;
import com.group.libraryapp.homework7.dto.response.FruitResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v7")
public class FruitControllerV7 {

    private final FruitServiceV7 fruitServiceV7;


    @PostMapping("/fruit")
    public void save(@RequestBody FruitCreateRequest fruitCreateRequest){
        fruitServiceV7.save(fruitCreateRequest);
    }

    @PutMapping("/fruit")
    public void updateIsSale(@RequestBody FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        fruitServiceV7.updateIsSale(fruitUpdateIsSaleRequest);
    }

    @GetMapping("/fruit/stat")
    public AmountByNameResponse amountByName(@RequestParam String name){
        return fruitServiceV7.amountByName(name);
    }

    @GetMapping("/fruit/count")
    public CountResponse countByName(@RequestParam String name){
        return fruitServiceV7.countByName(name);
    }

    @GetMapping("/fruit/list")
    public List<FruitResponse> listByPrice(FruitListByPriceRequest request){
        return fruitServiceV7.listByPrice(request);
    }

}
