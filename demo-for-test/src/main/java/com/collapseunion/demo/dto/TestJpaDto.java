package com.collapseunion.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * JPA 测试 数据传输类 => 页面搜索框
 *
 * @author CloudSen
 */
@Data
@Accessors(chain = true)
public class TestJpaDto implements Serializable {
    /**
     * 36位UUID
     */
    private String id;
    /**
     * 名字
     */
    private String name;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date createDate;
}
