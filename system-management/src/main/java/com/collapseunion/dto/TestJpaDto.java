package com.collapseunion.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * JPA 测试 数据传输类 => 页面搜索框
 *
 * @author CloudSen
 */
@Data
@Accessors(chain = true)
public class TestJpaDto {
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
    private Date createDate;
}
