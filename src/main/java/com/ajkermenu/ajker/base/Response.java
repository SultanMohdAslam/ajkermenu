package com.ajkermenu.ajker.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response <T>{
    private boolean status = true;
    private String massage;
    private T data;

    public Response(String massage, T data) {
        this.massage = massage;
        this.data = data;
    }
}
