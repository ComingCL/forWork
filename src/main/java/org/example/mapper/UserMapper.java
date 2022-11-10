package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/29 23:56
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
