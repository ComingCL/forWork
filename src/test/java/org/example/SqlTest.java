package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mapper.GoodsMapper;
import org.example.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SqlTest {
    @Resource
    private GoodsMapper goodsMapper;
    @Test
//    @Transactional
    public void test01(){
        String s = "qwertyuiopasdfghjklzxcvbnm";
        int len = s.length();
        List<Goods> goodsList = new LinkedList<>();
        for(int i=0;i<500000;i++){
            StringBuilder builder = new StringBuilder();
            int k = (int) (Math.random() * 10000000) % 10 + 1;
            for(int j=0;j<k%10;j++){
                int k2 = (int) (Math.random() * 10000009) % len;
                builder.append(s.charAt(k2));
            }
            Goods goods = new Goods();
            Date date = new Date(System.currentTimeMillis());
            int stock = k % 10000;
            goods.setGmt_create(date).setName(builder.toString()).setId(0)
                    .setPrice(k % 987654 * 1.0).setSale(stock / 10)
                    .setStock(stock).setGmt_modified(date).setVersion(1);
//            goodsMapper.insert(goods);
            goodsList.add(goods);
//            System.out.println(goods);
        }
        int result = goodsMapper.insertBatch(goodsList);
        System.out.println(result);
    }
    @Test
    public void test02(){
        long start = System.currentTimeMillis();
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.eq("name", null)
                .eq("sale", null);
        List<Goods> list = goodsMapper.selectList(wrapper);
        System.out.println(list.size());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    @Test
    public void test03(){
        Goods goods = new Goods();
        goods.setId(123);
        System.out.println(goods.getId());
        goods.setId(1245);
        System.out.println(goods.getId());
    }
}
