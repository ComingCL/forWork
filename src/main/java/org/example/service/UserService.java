package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.User;
import org.example.vo.LoginVo;
import org.example.vo.RespBean;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 20:52
 */
public interface UserService extends IService<User> {
    /**
     * 登录
     * @return
     */
    RespBean doLogin(LoginVo loginVo);
}
