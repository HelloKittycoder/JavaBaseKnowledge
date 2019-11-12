package com.kittycoder.ex05.bean.b;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by shucheng on 2019-11-12 下午 20:25
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
