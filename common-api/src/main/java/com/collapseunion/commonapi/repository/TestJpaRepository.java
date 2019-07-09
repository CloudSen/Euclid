package com.collapseunion.commonapi.repository;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * JPA测试
 *
 * @author CloudSen
 */
public interface TestJpaRepository extends JpaRepository<TestJpaEntity, String>,
        PagingAndSortingRepository<TestJpaEntity, String> {

    /**
     * 查找同日期创建的实体列表
     *
     * @param createDate 创建日期
     * @return 实体列表
     */
    List<TestJpaEntity> findByCreateDate(Date createDate);
}
