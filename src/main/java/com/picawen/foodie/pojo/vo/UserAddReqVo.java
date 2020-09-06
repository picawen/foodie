package com.picawen.foodie.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户注册请求VO
 *
 * @author Sven.Fu
 * @date 2020/9/6 11:15 下午
 */
@Data
public class UserAddReqVo implements Serializable {
    private static final long serialVersionUID = 730681905620984868L;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
