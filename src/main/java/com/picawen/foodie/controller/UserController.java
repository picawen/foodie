package com.picawen.foodie.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.picawen.foodie.common.R;
import com.picawen.foodie.pojo.User;
import com.picawen.foodie.pojo.vo.req.UserAddReqVo;
import com.picawen.foodie.pojo.vo.req.UserLoginReqVo;
import com.picawen.foodie.pojo.vo.resp.UserLoginRespVo;
import com.picawen.foodie.service.UserService;
import com.picawen.foodie.util.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author Sven.Fu
 * @date 2020/9/6 8:23 下午
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/isExistUserName")
    public R isExistUserName(String username) {
        if (StrUtil.isBlank(username)) {
            return new R("用户名不能为空");
        }
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
        if (user != null) {
            return new R("用户已存在");
        } else {
            return new R();
        }
    }

    /**
     * 用户注册
     *
     * @param vo
     * @return
     */
    @PostMapping("/register")
    public R register(@Validated @RequestBody UserAddReqVo vo, HttpServletRequest request, HttpServletResponse response) {
        if (!vo.getPassword().equals(vo.getConfirmPassword())) {
            return new R("密码与确认密码不一致");
        }
        User userDB = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getUsername, vo.getUsername()));
        if (userDB != null) {
            return new R("用户已存在");
        }
        User user = new User();
        user.setUsername(vo.getUsername());
        user.setPassword(SecureUtil.md5(vo.getPassword()));
        user.setNickname(vo.getUsername());
        user.setSex(2);
        user.setFace("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599416741688&di=19485781f6913a94142a4d165619003c&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F7Po3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2F267f9e2f07082838685c484ab999a9014c08f11f.jpg");
        user.setBirthday(LocalDateTimeUtil.parseDate("1970-01-01", "yyyy-MM-dd"));
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        userService.save(user);
        UserLoginRespVo result = new UserLoginRespVo();
        BeanUtil.copyProperties(user, result);
        CookieUtils.setCookie(request, response, "user", JSONUtil.toJsonStr(result), true);
        return new R<>(result);
    }

    /**
     * 用户登录
     *
     * @param vo
     * @return
     */
    @PostMapping("/login")
    public R login(@Validated @RequestBody UserLoginReqVo vo, HttpServletRequest request, HttpServletResponse response) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, vo.getUsername());
        queryWrapper.eq(User::getPassword, SecureUtil.md5(vo.getPassword()));
        User user = userService.getOne(queryWrapper);
        if (user == null) {
            return new R("用户名或密码错误");
        }
        UserLoginRespVo result = new UserLoginRespVo();
        BeanUtil.copyProperties(user, result);
        CookieUtils.setCookie(request, response, "user", JSONUtil.toJsonStr(result), true);
        return new R<>(result);
    }

    /**
     * 退出登录
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/logout")
    public R logout(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");
        return new R();
    }
}
