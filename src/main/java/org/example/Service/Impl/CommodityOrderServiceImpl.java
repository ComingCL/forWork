package org.example.Service.Impl;

import org.example.Mapper.CommodityOrderMapper;
import org.example.Mapper.GoodsMapper;
import org.example.Pojo.CommodityOrder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.Pojo.Goods;
import org.springframework.stereotype.Service;
import org.example.Service.CommodityOrderService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CommodityOrderServiceImpl extends ServiceImpl<CommodityOrderMapper, CommodityOrder> implements CommodityOrderService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private CommodityOrderMapper commodityOrderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public long overSold(Integer userId, Integer goodsId) {
        Goods goods = checkInventory(goodsId);
        deductInventory(goods);
        return generateOrders(userId, goodsId);
    }

    /**
     * 检测商品库存
     * @param goodsId 商品id
     * @return 如果库存充足返回商品信息, 否则抛出异常
     */
    private Goods checkInventory(Integer goodsId){
        Goods goods = goodsMapper.selectById(goodsId);
        if(goods.getSale() >= goods.getStock()){
            throw new RuntimeException(goods.getName() + "已经售空!");
        }
        return goods;
    }
    private long generateOrders(Integer userId, Integer goodsId){
        CommodityOrder order = new CommodityOrder()
                .setUserId(userId)
                .setGoodsId(goodsId);
        int row = commodityOrderMapper.insert(order);
        if(row == 0){
            throw new RuntimeException("生成订单失败!!!");
        }
        return order.getId();
    }
    private void deductInventory(Goods goods){
        int updateRows = goodsMapper.updateSaleOptimisticLock(goods);
        if(updateRows == 0){
            throw new RuntimeException("抢购失败, 请重试!");
        }
    }
}
