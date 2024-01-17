package com.basic.sb_batch.standard.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ut {
    public static class date{
        public static LocalDateTime parse(String pattern,String dateText){
            return LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern(pattern));
        }

        public static LocalDateTime parse(String dateText) {
            return parse("yyyy-MM-dd HH:mm:ss.SSSSSS", dateText);
        }
    }
}
