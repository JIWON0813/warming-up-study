package com.group.libraryapp.homework6.Service;

import com.group.libraryapp.homework6.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework6.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework6.dto.response.AmountByNameResponse;
import com.group.libraryapp.homework6.Repository.FruitRepositoryV6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FruitServiceV6 {

    private final FruitRepositoryV6 fruitRepositoryV6;

    public void save(FruitCreateRequest fruitCreateRequest){
       fruitRepositoryV6.save(fruitCreateRequest);
    }

    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        fruitRepositoryV6.updateIsSale(fruitUpdateIsSaleRequest);
    }

    public AmountByNameResponse amountBySale(String name){
        return fruitRepositoryV6.amountBySale(name);
    }
}
