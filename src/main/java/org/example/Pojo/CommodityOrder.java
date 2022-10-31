package org.example.Pojo;


import java.io.Serializable;
import java.util.Date;

public class CommodityOrder implements Serializable {
    Long id;
    Integer userId;
    Integer goodsId;
    Date gmt_create;
    Date gmt_modified;

    public CommodityOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public CommodityOrder setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public CommodityOrder setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public CommodityOrder setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
        return this;
    }

    public CommodityOrder() {
        this.gmt_create = new Date(System.currentTimeMillis());
        this.gmt_modified = this.gmt_create;
    }

    public CommodityOrder setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }
}
