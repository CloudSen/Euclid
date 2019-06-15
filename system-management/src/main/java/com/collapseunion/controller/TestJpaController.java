package com.collapseunion.controller;

import com.collapseunion.dto.TestJpaDto;
import com.collapseunion.entity.TestJpaEntity;
import com.collapseunion.service.TestJpaService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * JPA测试路由
 *
 * @author CloudSen
 */
@RestController
@RequestMapping("/jpa-test")
public class TestJpaController {

    private final TestJpaService testJpaService;

    public TestJpaController(TestJpaService testJpaService) {
        this.testJpaService = testJpaService;
    }

    @GetMapping("")
    public Object findAll() {
        return this.testJpaService.findAll();
    }

    @GetMapping("/id/{uuid}")
    public Object findById(@PathVariable("uuid") TestJpaEntity testJpaEntity) {
        return testJpaEntity;
    }

    @GetMapping("/date/{createDate}")
    public Object findByCreateDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate) {
        return this.testJpaService.findByCreateDate(createDate);
    }

    @PostMapping("/page")
    public Object pagingByCondition(TestJpaDto condition, Pageable pageable) {
        return this.testJpaService.pagingByCondition(condition, pageable);
    }

    @PostMapping("/queries")
    public Object findByCondition(@RequestBody TestJpaDto condition) {
        return this.testJpaService.findByCondition(condition);
    }

    @PostMapping("")
    public Object createNew(@RequestBody TestJpaDto newTestJpaDto) {
        return this.testJpaService.createNew(newTestJpaDto);
    }

    @PutMapping("/{uuid}")
    public Object deleteById(@PathVariable String uuid) {
        this.testJpaService.deleteById(uuid);
        // TODO 后面添加全局统一返回对象
        return true;
    }

    @PutMapping("")
    public Object update(@RequestBody TestJpaDto newTestJpaDto) {
        return this.testJpaService.update(newTestJpaDto);
    }
}
