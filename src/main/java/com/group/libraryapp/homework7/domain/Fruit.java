package com.group.libraryapp.homework7.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    public Fruit(String name, long price, LocalDate warehousingDate){
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
        this.isSale = false;
    }

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    private long price;

    @Column(name = "is_sale")
    private boolean isSale;

    @Column(name = "warehousing_date")
    private LocalDate warehousingDate;

    public void updateIsSale(){
        this.isSale = !this.isSale;
    }
}
