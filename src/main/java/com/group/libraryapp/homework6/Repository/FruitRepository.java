package com.group.libraryapp.homework6.Repository;

import com.group.libraryapp.homework6.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework6.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework6.dto.response.AmountByNameResponse;

public interface FruitRepository {
    void save(FruitCreateRequest fruitCreateRequest);
    void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest);

    AmountByNameResponse amountBySale(String name);
}
