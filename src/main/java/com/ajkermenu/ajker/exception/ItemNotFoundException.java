package com.ajkermenu.ajker.exception;

import com.ajkermenu.ajker.utils.ConstantUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException  extends  RuntimeException{
    public ItemNotFoundException() {
        super(ConstantUtils.NO_DATA_FOUND);
    }
}
