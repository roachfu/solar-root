package com.roachfu.solar.client.user.mapper;

import com.roachfu.solar.client.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户mapper层
 *
 * Created by roach on 08/08/2017.
 */
@Repository
public interface UserMapper {
    User selectUserList();

}
