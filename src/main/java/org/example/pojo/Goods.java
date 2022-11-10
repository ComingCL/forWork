package org.example.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private double price;
    private Integer stock;
    private Integer sale;
    private Integer version;
    private Date gmt_create;
    private Date gmt_modified;

    public Integer getId() {
        return id;
    }

    public Goods setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Goods setPrice(double price) {
        this.price = price;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Goods setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Integer getSale() {
        return sale;
    }

    public Goods setSale(Integer sale) {
        this.sale = sale;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public Goods setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public Goods setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
        return this;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public Goods setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
        return this;
    }
}
