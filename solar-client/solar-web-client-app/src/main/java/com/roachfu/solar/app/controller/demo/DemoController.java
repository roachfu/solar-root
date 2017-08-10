package com.roachfu.solar.app.controller.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo 控制器
 *
 * Created by roach on 09/08/2017.
 */

@RestController
@RequestMapping(value = "/v1/demos")
public class DemoController {

    @GetMapping
    public Object getDemo(){
        return "just a demo";
    }
}
