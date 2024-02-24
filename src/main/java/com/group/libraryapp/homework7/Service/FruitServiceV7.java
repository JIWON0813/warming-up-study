package com.group.libraryapp.homework7.Service;

import com.group.libraryapp.homework7.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework7.dto.response.AmountByNameResponse;
import com.group.libraryapp.homework7.domain.Fruit;
import com.group.libraryapp.homework7.domain.FruitRepository;
import com.group.libraryapp.homework7.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework7.dto.request.FruitListByPriceRequest;
import com.group.libraryapp.homework7.dto.response.CountResponse;
import com.group.libraryapp.homework7.dto.response.FruitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FruitServiceV7 {

    private final FruitRepository fruitRepository;

    public void save(FruitCreateRequest request){
        Fruit fruit = fruitRepository.save(new Fruit(request.getName(),request.getPrice(),request.getWarehousingDate()));
    }

    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        Fruit fruit = fruitRepository.findById(fruitUpdateIsSaleRequest.getId()).orElseThrow(IllegalArgumentException::new);

        fruit.updateIsSale();

        fruitRepository.save(fruit);
    }

    public AmountByNameResponse amountByName(String name){
        List<Fruit> fruits = fruitRepository.findAllByName(name);

        long salesAmount = fruits.stream()
                                .filter(Fruit::isSale)
                                .mapToLong(Fruit::getPrice)
                                .sum();
        long notSalesAmount = fruits.stream()
                                    .filter(fruit -> !fruit.isSale())
                                    .mapToLong(Fruit::getPrice)
                                    .sum();

        return new AmountByNameResponse(salesAmount,notSalesAmount);
    }

    public CountResponse countByName(String name){
        long count = fruitRepository.countByName(name);

        return new CountResponse(count);
    }
    public List<FruitResponse> listByPrice(FruitListByPriceRequest request){
        if(request.getOption().equals("GTE")){
            List<Fruit> fruits = fruitRepository.findByPriceGreaterThanEqual(request.getPrice());
            return fruits.stream().map(fruit -> new FruitResponse(fruit.getName(),fruit.getPrice(),fruit.getWarehousingDate())).collect(Collectors.toList());
        }
        else if(request.getOption().equals("LTE")){
            List<Fruit> fruits = fruitRepository.findByPriceLessThanEqual(request.getPrice());
            return fruits.stream().map(fruit -> new FruitResponse(fruit.getName(),fruit.getPrice(),fruit.getWarehousingDate())).collect(Collectors.toList());
        }

        throw new IllegalArgumentException();
    }
}
