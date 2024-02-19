package com.group.libraryapp.homework4.Service;

import com.group.libraryapp.homework4.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework4.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework4.dto.response.AmountByNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final JdbcTemplate jdbcTemplate;

    public void save(FruitCreateRequest fruitCreateRequest){
        String sql = "INSERT INTO fruit VALUES (?,?, false,?)";

        jdbcTemplate.update(sql, fruitCreateRequest.getName(), fruitCreateRequest.getPrice(), fruitCreateRequest.getWarehousingDate());
    }

    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        String sql = "UPDATE fruit set is_sale = true where ?";

        jdbcTemplate.update(sql, fruitUpdateIsSaleRequest.getId());
    }

    public AmountByNameResponse amountByName(String name){
        String sql = "SELECT * FROM fruit WHERE name = ?";
        jdbcTemplate.queryForList(sql);
        //TODO...
        AmountByNameResponse response = new AmountByNameResponse(1,2);
        return response;
    }
}
