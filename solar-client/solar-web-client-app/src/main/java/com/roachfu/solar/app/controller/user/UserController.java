package com.roachfu.solar.app.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roach on 08/08/2017.
 */

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping
    public String getUser(){

        return "Hello World";
    }


}
