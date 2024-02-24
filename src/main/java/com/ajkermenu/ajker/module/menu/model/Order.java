package com.ajkermenu.ajker.module.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Collation("order")
public class Order {

    @Id
    private String orderId;
    private Integer amount;
    private String chefId;
    private String customerId;

}
