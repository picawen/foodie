package com.picawen.foodie.pojo.vo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户登录请求VO
 *
 * @author Sven.Fu
 * @date 2020/9/6 11:50 下午
 */
@Data
public class UserLoginReqVo implements Serializable {
    private static final long serialVersionUID = -4900360723591629179L;
    @NotBlank(message = "用户不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
