package com.kittycoder.ex05.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by shucheng on 2019-11-12 下午 17:52
 */
@Controller
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    public String test() {
        logger.debug(userService);
        return "test";
    }
}
