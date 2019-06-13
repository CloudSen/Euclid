package com.collapseunion.service;

import com.collapseunion.dto.TestJpaDto;
import com.collapseunion.entity.TestJpaEntity;

import java.util.Date;
import java.util.List;

/**
 * JPA测试
 *
 * @author CloudSen
 */
public interface TestJpaService {

    /**
     * 通过ID查找实体
     *
     * @param uuid 36位UUID
     * @return 唯一实体
     */
    TestJpaEntity findById(String uuid);

    /**
     * 查找同日期创建的实体列表
     *
     * @param createDate 创建日期
     * @return 实体列表
     */
    List<TestJpaEntity> findByCreateDate(Date createDate);

    /**
     * 获取所有
     *
     * @return 实体列表
     */
    List<TestJpaEntity> findAll();

    /**
     * 通过页面的查询条件查询
     *
     * @param condition 查询条件
     * @return 实体列表
     */
    List<TestJpaEntity> findByCondition(TestJpaDto condition);

    /**
     * 创建新的条目
     *
     * @param testJpaDto 新实体数据
     * @return 包含ID的实体
     */
    TestJpaEntity createNew(TestJpaDto testJpaDto);

    /**
     * 通过ID删除某个实体
     *
     * @param uuid 36位的UUID
     */
    void deleteById(String uuid);

    /**
     * 根据ID 更新某个实体
     *
     * @param testJpaDto 旧实体的数据
     * @return 更新后的实体
     */
    TestJpaEntity update(TestJpaDto testJpaDto);
}
