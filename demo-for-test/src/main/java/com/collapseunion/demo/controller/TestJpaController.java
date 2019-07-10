package com.collapseunion.demo.controller;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import com.collapseunion.commonutils.globalresult.ResultUtil;
import com.collapseunion.demo.DemoApplication;
import com.collapseunion.demo.dto.TestJpaDto;
import com.collapseunion.demo.service.TestJpaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

/**
 * <p>JPA测试路由</p>
 * <p>这里偷一下懒， 成功返回的状态吗都是200</p>
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
    public Result<Collection<TestJpaEntity>> findAll() {
        return ResultUtil.ok(this.testJpaService.findAll(), DemoApplication.APPLICATION_NAME);
    }

    @GetMapping("/id/{uuid}")
    public Result<TestJpaEntity> findById(@PathVariable("uuid") TestJpaEntity testJpaEntity) {
        return ResultUtil.ok(testJpaEntity, DemoApplication.APPLICATION_NAME);
    }

    @GetMapping("/date/{createDate}")
    public Result<Collection<TestJpaEntity>> findByCreateDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate) {
        return ResultUtil.ok(this.testJpaService.findByCreateDate(createDate), DemoApplication.APPLICATION_NAME);
    }

    @PostMapping("/page")
    public Result<Page<TestJpaEntity>> pagingByCondition(TestJpaDto condition, Pageable pageable) {
        return ResultUtil.ok(this.testJpaService.pagingByCondition(condition, pageable), DemoApplication.APPLICATION_NAME);
    }

    @PostMapping("/queries")
    public Result<Collection<TestJpaEntity>> findByCondition(@RequestBody TestJpaDto condition) {
        return ResultUtil.ok(this.testJpaService.findByCondition(condition), DemoApplication.APPLICATION_NAME);
    }

    @PostMapping("")
    public Result<TestJpaEntity> createNew(@RequestBody TestJpaDto newTestJpaDto) {
        return ResultUtil.ok(this.testJpaService.createNew(newTestJpaDto), DemoApplication.APPLICATION_NAME);
    }

    @DeleteMapping("/{uuid}")
    public Result<Boolean> deleteById(@PathVariable String uuid) {
        this.testJpaService.deleteById(uuid);
        return ResultUtil.ok(DemoApplication.APPLICATION_NAME);
    }

    @PutMapping("")
    public Result<TestJpaEntity> update(@RequestBody TestJpaDto newTestJpaDto) {
        return ResultUtil.ok(this.testJpaService.update(newTestJpaDto), DemoApplication.APPLICATION_NAME);
    }
}
