package org.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 14:37
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
//    通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),
//    登录模块
    LOGIN_ERROR(500210, "用户名或密码不正确"),
    MOBILE_ERROR(500211, "手机号格式不正确")
    ;
    private final Integer code;
    private final String message;
}
