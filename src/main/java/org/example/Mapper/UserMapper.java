package org.example.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.Pojo.User;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 23:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
