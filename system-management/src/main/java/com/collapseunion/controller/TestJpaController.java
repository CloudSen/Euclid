package com.collapseunion.controller;

import com.collapseunion.dto.TestJpaDto;
import com.collapseunion.entity.TestJpaEntity;
import com.collapseunion.service.TestJpaService;
import com.collapseunion.util.globalresult.Result;
import com.collapseunion.util.globalresult.ResultUtil;
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
        return ResultUtil.ok(this.testJpaService.findAll());
    }

    @GetMapping("/id/{uuid}")
    public Result<TestJpaEntity> findById(@PathVariable("uuid") TestJpaEntity testJpaEntity) {
        return ResultUtil.ok(testJpaEntity);
    }

    @GetMapping("/date/{createDate}")
    public Result<Collection<TestJpaEntity>> findByCreateDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate) {
        return ResultUtil.ok(this.testJpaService.findByCreateDate(createDate));
    }

    @PostMapping("/page")
    public Result<Page<TestJpaEntity>> pagingByCondition(TestJpaDto condition, Pageable pageable) {
        return ResultUtil.ok(this.testJpaService.pagingByCondition(condition, pageable));
    }

    @PostMapping("/queries")
    public Result<Collection<TestJpaEntity>> findByCondition(@RequestBody TestJpaDto condition) {
        return ResultUtil.ok(this.testJpaService.findByCondition(condition));
    }

    @PostMapping("")
    public Result<TestJpaEntity> createNew(@RequestBody TestJpaDto newTestJpaDto) {
        return ResultUtil.ok(this.testJpaService.createNew(newTestJpaDto));
    }

    @DeleteMapping("/{uuid}")
    public Result<Boolean> deleteById(@PathVariable String uuid) {
        this.testJpaService.deleteById(uuid);
        return ResultUtil.ok();
    }

    @PutMapping("")
    public Object update(@RequestBody TestJpaDto newTestJpaDto) {
        return this.testJpaService.update(newTestJpaDto);
    }
}
