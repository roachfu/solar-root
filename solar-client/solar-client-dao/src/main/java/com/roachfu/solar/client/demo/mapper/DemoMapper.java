package com.roachfu.solar.client.demo.mapper;

import com.roachfu.solar.client.demo.entity.Demo;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据id获取demo详情
     * @param id 主键id
     * @return
     */
    Demo selectDemoById(@Param("id") String id);

    /**
     * 根据id查询demo的记录数
     * @param demoId
     * @return
     */
    int countDemoById(@Param("id") String demoId);

    /**
     * 根据id删除demo
     * @param demoId
     * @return
     */
    int deleteDemoById(String demoId);
}
