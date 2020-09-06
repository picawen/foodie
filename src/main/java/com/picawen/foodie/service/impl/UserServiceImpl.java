package com.picawen.foodie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.picawen.foodie.mapper.UserMapper;
import com.picawen.foodie.pojo.User;
import com.picawen.foodie.pojo.vo.req.UserAddReqVo;
import com.picawen.foodie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author Sven.Fu
 * @date 2020/9/6 8:20 下午
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User register(UserAddReqVo vo) {
        return null;
    }
}
