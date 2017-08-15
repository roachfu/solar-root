package com.roachfu.solar.client.demo.service.impl;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.base.eums.ErrorTypeEnum;
import com.roachfu.solar.client.demo.entity.Demo;
import com.roachfu.solar.client.demo.mapper.DemoMapper;
import com.roachfu.solar.client.demo.service.DemoService;
import com.roachfu.solar.client.demo.vo.DemoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * demo 业务逻辑实现
 *
 * @author roach
 * @date 13/08/2017 11:28
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<DemoVO> listDemo() {

        List<Demo> demoList = demoMapper.selectDemoList();
        List<DemoVO> demoVOList = new ArrayList<>();

        for (Demo demo : demoList) {
            DemoVO demoVO = new DemoVO();
            BeanUtils.copyProperties(demo, demoVO);
            demoVOList.add(demoVO);
        }

        return demoVOList;
    }

    @Override
    public DemoVO getDemo(String id) {
        Demo demo = demoMapper.selectDemoById(id);
        DemoVO demoVO = new DemoVO();
        if(demo != null) {
            BeanUtils.copyProperties(demo, demoVO);
        }
        return demoVO;
    }

    @Override
    public APIResponse deleteDemo(String demoId) {
        // 判断demoId是否存在
        int count = demoMapper.countDemoById(demoId);
        if(count == 0){
            return new APIResponse(ErrorTypeEnum.NOT_FOUNT);
        }

        // 删除
        int flag = demoMapper.deleteDemoById(demoId);
        if (flag == 0){
            return new APIResponse(ErrorTypeEnum.FAILURE);
        }

        return new APIResponse();
    }
}
