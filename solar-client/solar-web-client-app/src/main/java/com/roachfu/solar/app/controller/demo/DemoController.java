package com.roachfu.solar.app.controller.demo;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * demo 控制器
 *
 * Created by roach on 09/08/2017.
 */

@RestController
@RequestMapping(value = "/v1/demos")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping
    public APIResponse getDemo(){
        return new APIResponse(demoService.listDemo());
    }
}
