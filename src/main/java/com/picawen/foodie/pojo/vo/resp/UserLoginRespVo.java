package com.picawen.foodie.pojo.vo.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录响应VO
 *
 * @author Sven.Fu
 * @date 2020/9/7 12:08 上午
 */
@Data
public class UserLoginRespVo implements Serializable {
    private static final long serialVersionUID = 7634198259569877514L;
    private Long id;
    private String username;
    private String nickname;
    private String face;
    private Integer sex;
}
