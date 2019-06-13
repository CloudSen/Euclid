package com.collapseunion.repository;

import com.collapseunion.entity.TestJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * JPA测试
 *
 * @author CloudSen
 */
public interface TestJpaRepository extends JpaRepository<TestJpaEntity, String> {

    /**
     * 查找同日期创建的实体列表
     *
     * @param createDate 创建日期
     * @return 实体列表
     */
    List<TestJpaEntity> findByCreateDate(Date createDate);
}
