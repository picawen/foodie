package com.picawen.foodie.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户表
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String realName;
    private String face;
    private String mobile;
    private String email;
    private Integer sex;
    private LocalDate birthday;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
