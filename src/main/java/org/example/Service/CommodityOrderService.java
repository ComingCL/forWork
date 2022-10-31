package org.example.Service;

import org.example.Pojo.CommodityOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Update;

public interface CommodityOrderService extends IService<CommodityOrder> {
    /**
     * 超卖现象
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 返回生成的订单id
     */
    long overSold(Integer userId, Integer goodsId);
}
