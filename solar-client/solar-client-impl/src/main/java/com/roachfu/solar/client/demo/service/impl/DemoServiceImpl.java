package com.roachfu.solar.client.demo.service.impl;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.base.eums.ErrorEnum;
import com.roachfu.solar.client.demo.dto.DemoAddDTO;
import com.roachfu.solar.client.demo.dto.DemoUpdateDTO;
import com.roachfu.solar.client.demo.entity.Demo;
import com.roachfu.solar.client.demo.mapper.DemoMapper;
import com.roachfu.solar.client.demo.service.DemoService;
import com.roachfu.solar.client.demo.vo.DemoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * demo 业务逻辑实现
 *
 * @author roach
 * @date 13/08/2017 11:28
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

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
            return new APIResponse(ErrorEnum.NOT_FOUNT);
        }

        // 删除
        int flag = demoMapper.deleteDemoById(demoId);
        if (flag == 0){
            return new APIResponse(ErrorEnum.FAILURE);
        }

        return new APIResponse();
    }

    @Override
    public APIResponse saveDemo(DemoAddDTO demoAddDTO) {
        Demo demo = new Demo();
        demo.init();
        BeanUtils.copyProperties(demoAddDTO, demo);
        LOGGER.info("{}", demo);
        int flag = demoMapper.insertDemo(demo);
        if (flag > 0){
            return new APIResponse();
        }
        return new APIResponse(ErrorEnum.FAILURE);
    }

    @Override
    public APIResponse updateDemo(DemoUpdateDTO demoUpdateDTO) {
        // 判断demo是否存在
        int count = demoMapper.countDemoById(demoUpdateDTO.getId());
        if(count == 0){
            return new APIResponse(ErrorEnum.NOT_FOUNT);
        }

        Demo demo = new Demo();
        BeanUtils.copyProperties(demoUpdateDTO, demo);
        demo.setUpdateTime(new Date());
        int flag = demoMapper.updateDemoById(demo);
        if (flag > 0){
            return new APIResponse();
        }
        return new APIResponse(ErrorEnum.FAILURE);
    }
}
