package com.acesif.graphQL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
public class Order {

    private UUID id;
    private String description;
    private Integer totalCost;
    private Integer quantity;
}
