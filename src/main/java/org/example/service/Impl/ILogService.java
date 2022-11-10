package org.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.LogMapper;
import org.example.pojo.LogEntity;
import org.example.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class ILogService extends ServiceImpl<LogMapper, LogEntity> implements LogService {
}
