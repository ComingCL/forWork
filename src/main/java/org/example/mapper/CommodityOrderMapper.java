package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.CommodityOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommodityOrderMapper extends BaseMapper<CommodityOrder> {
}
