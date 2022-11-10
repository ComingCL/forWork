package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "log")
public class LogEntity implements Serializable {
    private BigInteger id;
    private String user_code;
    private String ip;
    private String type;
    private String description;
    private String model;
    private Date operation_time;
    private String result;

    public BigInteger id() {
        return id;
    }

    public LogEntity setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String user_code() {
        return user_code;
    }

    public LogEntity setUser_code(String user_code) {
        this.user_code = user_code;
        return this;
    }

    public String ip() {
        return ip;
    }

    public LogEntity setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String type() {
        return type;
    }

    public LogEntity setType(String type) {
        this.type = type;
        return this;
    }

    public String description() {
        return description;
    }

    public LogEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String model() {
        return model;
    }

    public LogEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public Date operation_time() {
        return operation_time;
    }

    public LogEntity setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
        return this;
    }

    public String result() {
        return result;
    }

    public LogEntity setResult(String result) {
        this.result = result;
        return this;
    }
}
