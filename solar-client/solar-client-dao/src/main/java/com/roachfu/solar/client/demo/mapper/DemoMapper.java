package com.roachfu.solar.client.demo.mapper;

import com.roachfu.solar.client.demo.entity.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by roach on 13/08/2017.
 */

@Repository
public interface DemoMapper {

    /**
     * 获取demo列表
     * @return
     */
    List<Demo> selectDemoList();
}
