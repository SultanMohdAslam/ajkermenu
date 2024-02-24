package com.ajkermenu.ajker.module.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Collation("customer")
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String customerType;

}
