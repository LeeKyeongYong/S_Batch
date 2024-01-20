package com.basic.sb_batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class AppConfig {

    private static String activeProfile;

    @Value("${spring.profiles.active}")
    public void setAvtiveProfile(String value){
        activeProfile = value;
    }
    public static boolean isNotProd() {
        return isProd() == false;
    }
    public static boolean isProd(){
        return activeProfile.equals("prod");
    }

    public static boolean isNotDev(){
        return isDev() == false;
    }
    public static boolean isDev(){
        return activeProfile.equals("dev");
    }

    public static boolean isNotTest(){
        return isDev() == false;
    }

    public static boolean isTest(){
        return activeProfile.equals("test");
    }

}
