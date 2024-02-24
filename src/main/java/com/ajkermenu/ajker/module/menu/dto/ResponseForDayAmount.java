package com.ajkermenu.ajker.module.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseForDayAmount {
    private String chefName;
    private Integer amount;
}
