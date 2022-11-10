package org.example.service;

import org.example.pojo.CommodityOrder;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CommodityOrderService extends IService<CommodityOrder> {
    /**
     * 超卖现象
     * @param userId 用户id
     * @param goodsId 商品id
     * @return 返回生成的订单id
     */
    long overSold(Integer userId, Integer goodsId);
}
