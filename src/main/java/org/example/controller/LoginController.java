package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.example.annotation.SystemLog;
import org.example.vo.LoginVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 14:32
 */
@RestController
@RequestMapping("/login")
@Slf4j

public class LoginController {
    /**
     * 跳转登录页面
     * @return 返回登录页面
     */
    @RequestMapping("/toLogin")
    @SystemLog(title = "LoginController", message = "message")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody

    public String doLogin(LoginVo loginVo){
        log.info("{}", loginVo);
        return null;
    }
}
