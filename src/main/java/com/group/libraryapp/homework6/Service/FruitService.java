package com.group.libraryapp.homework6.Service;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.group.libraryapp.homework4.dto.data.SalesAmountData;
import com.group.libraryapp.homework4.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework4.dto.request.FruitUpdateIsSaleRequest;
import com.group.libraryapp.homework4.dto.response.AmountByNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FruitService {

    private final JdbcTemplate jdbcTemplate;

    public void save(FruitCreateRequest fruitCreateRequest){
        String sql = "INSERT INTO fruit VALUES (null,?,?,false,?)";

        jdbcTemplate.update(sql, fruitCreateRequest.getName(), fruitCreateRequest.getPrice(), fruitCreateRequest.getWarehousingDate());
    }

    public void updateIsSale(FruitUpdateIsSaleRequest fruitUpdateIsSaleRequest){
        String sql = "UPDATE fruit set is_sale = true where id = ?";

        jdbcTemplate.update(sql, fruitUpdateIsSaleRequest.getId());
    }

    public AmountByNameResponse amountBySale(String name){
        String sql = "SELECT is_sale, SUM(price) AS total_price FROM fruit WHERE name = ? GROUP BY is_sale";

        var result = jdbcTemplate.query(sql, new RowMapper<SalesAmountData>() {
            @Override
            public SalesAmountData mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new SalesAmountData(rs.getBoolean(1), rs.getLong(2));
            }
        }, name);

        long salesAmount = 0;
        long notSalesAmount = 0;
        for (var data: result) {
            if(data.isSale()){
                salesAmount = data.getAmount();
            }
            else{
                notSalesAmount = data.getAmount();
            }
        }

        AmountByNameResponse response = new AmountByNameResponse(salesAmount,notSalesAmount);
        return response;
    }
}
