package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 不包含乐观锁,
     * 根据商品id去扣除库存, 数据库操作只有一个线程
     * @param goods 商品
     * @return 影响行数
     */
    @Update("update goods set sale = sale + 1, gmt_modified = now() where id = #{id}")
    int updateSaleNoOptimisticLock(Goods goods);

    /**
     * 包含乐观锁
     * 根据商品Id去扣除库存, 数据库操作只有一个线程去操作
     * 注意version++的时候应该直接在MySQL语句中写, 而不是在java中
     * @param goods 商品
     * @return 影响行数
     */
    @Update("update goods set sale = sale + 1,version = version + 1, gmt_modified = now() where id = #{id} and version = #{version}")
    int updateSaleOptimisticLock(Goods goods);

    int insertBatch(@Param("list") List<Goods> list);
}
