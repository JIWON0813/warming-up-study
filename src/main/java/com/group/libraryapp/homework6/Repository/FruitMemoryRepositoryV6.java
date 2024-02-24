package com.group.libraryapp.homework6.Repository;

import com.group.libraryapp.homework6.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework6.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework6.dto.response.AmountByNameResponse;
import org.springframework.stereotype.Repository;

@Repository
public class FruitMemoryRepositoryV6 implements FruitRepositoryV6 {
    @Override
    public void save(FruitCreateRequest fruitCreateRequest) {
    }

    @Override
    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest) {
    }

    @Override
    public AmountByNameResponse amountBySale(String name) {
        return null;
    }
}
