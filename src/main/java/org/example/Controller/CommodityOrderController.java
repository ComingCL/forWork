package org.example.Controller;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.example.Service.CommodityOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/commodity-order")
@Slf4j
public class CommodityOrderController {
    @Resource
    private CommodityOrderService commodityOrderService;

    @PostMapping("/overSold")
    public R<String> overSold(Integer userId, Integer goodsId){
        log.info("用户Id = {}, 商品id = {}", userId, goodsId);
        try{
            long orderId = commodityOrderService.overSold(userId, goodsId);
            return R.ok(String.valueOf(orderId));
        }catch (RuntimeException e){
            e.printStackTrace();
            return R.failed(e.getMessage());
        }
    }
}
