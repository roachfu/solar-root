package com.roachfu.solar.app.controller.demo;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 获取demo列表
     * @return demo列表
     */
    @GetMapping
    public APIResponse queryDemoList(){
        return new APIResponse(demoService.listDemo());
    }

    /**
     * 获取单个demo
     * @param demoId demo主键id
     * @return 查询结果
     */
    @GetMapping(value = "/{id}")
    public APIResponse queryDemo(@PathVariable("id")String demoId){
        return new APIResponse(demoService.getDemo(demoId));
    }

    /**
     * 删除单个demo
     * @param demoId demo主键
     * @return 删除结果
     */
    @DeleteMapping(value = "/{id}")
    public APIResponse deleteDemo(@PathVariable("id")String demoId){
        return demoService.deleteDemo(demoId);
    }
}
