package com.group.libraryapp.homework6.Service;

import com.group.libraryapp.homework6.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework6.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework6.dto.response.AmountByNameResponse;
import com.group.libraryapp.homework6.Repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FruitServiceV6 {

    private final FruitRepository fruitRepository;

    public void save(FruitCreateRequest fruitCreateRequest){
       fruitRepository.save(fruitCreateRequest);
    }

    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        fruitRepository.updateIsSale(fruitUpdateIsSaleRequest);
    }

    public AmountByNameResponse amountBySale(String name){
        return fruitRepository.amountBySale(name);
    }
}
