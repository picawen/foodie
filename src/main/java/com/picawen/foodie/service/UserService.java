package com.picawen.foodie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.picawen.foodie.pojo.User;
import com.picawen.foodie.pojo.vo.req.UserAddReqVo;

/**
 * 用户
 *
 * @author Sven.Fu
 * @date 2020/9/6 8:18 下午
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param vo
     * @return
     */
    User register(UserAddReqVo vo);
}
