package com.ajkermenu.ajker.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {

    public static String incrementDate(String fromDate){
        LocalDate localDate = LocalDate.parse(fromDate);
        LocalDate incrementedDate = localDate.plusDays(1);
        return incrementedDate.format(DateTimeFormatter.ofPattern(ConstantUtils.DATE_FORMAT));

    }
}
