package com.roachfu.solar.app.controller.demo;

import com.roachfu.solar.app.controller.base.BaseController;
import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.demo.dto.DemoAddDTO;
import com.roachfu.solar.client.demo.dto.DemoUpdateDTO;
import com.roachfu.solar.client.demo.service.DemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * demo 控制器
 *
 * Created by roach on 09/08/2017.
 */
@RestController
@RequestMapping(value = "/v1/demos")
public class DemoController extends BaseController{

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

    /**
     * 新增一条demo记录
     * @param demoAddDTO demo添加请求实体
     * @return
     */
    @PostMapping
    public APIResponse addDemo(@RequestBody @Valid DemoAddDTO demoAddDTO){
        return demoService.saveDemo(demoAddDTO);
    }

    /**
     * 更新demo
     * @param demoUpdateDTO 更新参数
     * @return 更新结果
     */
    @PutMapping(value = "/{id}")
    public APIResponse updateDemo(@RequestBody @Valid DemoUpdateDTO demoUpdateDTO, @PathVariable("id") String demoId){
        demoUpdateDTO.setId(demoId);
        return demoService.updateDemo(demoUpdateDTO);
    }
}
