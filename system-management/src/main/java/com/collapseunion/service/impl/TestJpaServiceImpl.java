package com.collapseunion.service.impl;

import com.collapseunion.dto.TestJpaDto;
import com.collapseunion.entity.TestJpaEntity;
import com.collapseunion.repository.TestJpaRepository;
import com.collapseunion.service.TestJpaService;
import com.collapseunion.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author CloudSen
 */
@Slf4j
@Service
public class TestJpaServiceImpl implements TestJpaService {

    private final TestJpaRepository testJpaRepository;

    public TestJpaServiceImpl(TestJpaRepository testJpaRepository) {
        this.testJpaRepository = testJpaRepository;
    }

    @Override
    public TestJpaEntity findById(String uuid) {
        log.info(Constants.FINDING_BY_ID, uuid);
        return this.testJpaRepository.getOne(uuid);
    }

    @Override
    public List<TestJpaEntity> findByCreateDate(Date createDate) {
        log.info(Constants.FINDING_BY_CREATE_DATE,
                TimeUtil.parseDateToString(createDate, TimeUtil.YYYY_MM_DD));
        return this.testJpaRepository.findByCreateDate(createDate);
    }

    @Override
    public List<TestJpaEntity> findAll() {
        log.info(Constants.FINDING_ALL);
        return this.testJpaRepository.findAll();
    }

    @Override
    public List<TestJpaEntity> findByCondition(TestJpaDto condition) {
        log.info(Constants.FINDING_BY_CONDITION, condition);
        TestJpaEntity testEntity = new TestJpaEntity()
                .setId(condition.getId())
                .setName(condition.getName())
                .setCreateDate(condition.getCreateDate());
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatcher::contains)
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains);
        Example<TestJpaEntity> example = Example.of(testEntity, exampleMatcher);
        return this.testJpaRepository.findAll(example);
    }

    @Override
    public TestJpaEntity createNew(TestJpaDto testJpaDto) {
        log.info(Constants.CREATING_TEST_ENTITY, testJpaDto);
        List<TestJpaEntity> existsEntities = this.findByCondition(testJpaDto);
        if (!CollectionUtils.isEmpty(existsEntities)) {
            // TODO 以后添加自定义运行时异常
            throw new RuntimeException(Constants.TEST_ENTITY_EXISTS);
        }
        TestJpaEntity newEntity = new TestJpaEntity()
                .setId(UUID.randomUUID().toString())
                .setCreateDate(new Date())
                .copyValueFromDto(testJpaDto);
        return this.testJpaRepository.save(newEntity);
    }

    @Override
    public void deleteById(String uuid) {
        log.info(Constants.DEL_TEST_ENTITY, uuid);
        this.testJpaRepository.deleteById(uuid);
    }

    @Override
    public TestJpaEntity update(TestJpaDto testJpaDto) {
        TestJpaEntity oldEntity = this.findById(testJpaDto.getId());
        if (oldEntity == null) {
            // TODO 以后添加自定义运行时异常
            throw new RuntimeException(Constants.TEST_ENTITY_NOT_EXISTS);
        }
        TestJpaEntity needUpdateEntity = oldEntity
                .setUpdateDate(new Date())
                .copyValueFromDto(testJpaDto);
        return this.testJpaRepository.save(needUpdateEntity);
    }
}
