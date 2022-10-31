package org.example.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.Mapper.UserMapper;
import org.example.Pojo.User;
import org.example.Service.UserService;
import org.example.vo.LoginVo;
import org.example.vo.RespBean;
import org.example.vo.RespBeanEnum;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 20:53
 */
@Service
public class IUserService extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public RespBean doLogin(LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        User user = userMapper.selectById(mobile);
        return null;
    }
}
