package com.kittycoder.ex05.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2019-11-12 下午 18:06
 */
@Component
public class MyUtil {

    @Value("#{2*10}")
    private int id;
    @Value("myutil")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
