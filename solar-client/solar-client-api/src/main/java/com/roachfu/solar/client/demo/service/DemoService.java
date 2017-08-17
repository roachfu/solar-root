package com.roachfu.solar.client.demo.service;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.demo.dto.DemoAddDTO;
import com.roachfu.solar.client.demo.vo.DemoVO;

import java.util.List;

/**
 * demo 业务逻辑接口层
 *
 * @author roach
 * @date 13/08/2017 11:26
 */
public interface DemoService {

    /**
     * 获取demo列表
     * @return 列表
     */
    List<DemoVO> listDemo();

    /**
     * 获取demo详情
     * @param id demo主键
     * @return
     */
    DemoVO getDemo(String id);

    /**
     * 删除demo
     * @param demoId demo主键id
     * @return
     */
    APIResponse deleteDemo(String demoId);

    /**
     * 新增一条demo记录
     * @param demoAddDTO 请求参数
     * @return 新增结果
     */
    APIResponse saveDemo(DemoAddDTO demoAddDTO);
}
