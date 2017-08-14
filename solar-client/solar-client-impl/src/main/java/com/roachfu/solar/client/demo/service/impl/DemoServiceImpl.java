package com.roachfu.solar.client.demo.service.impl;

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
}
