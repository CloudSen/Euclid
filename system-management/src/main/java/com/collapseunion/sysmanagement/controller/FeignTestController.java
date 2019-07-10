package com.collapseunion.sysmanagement.controller;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import com.collapseunion.sysmanagement.feignclients.DemoClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

/**
 * feign测试路由
 *
 * @author CloudSen
 */
@RestController
@RequestMapping("/feign-test")
public class FeignTestController {

    private final DemoClient demoClient;

    public FeignTestController(DemoClient demoClient) {
        this.demoClient = demoClient;
    }

    @GetMapping("")
    public Result<Collection<TestJpaEntity>> findAll() {
        return this.demoClient.findAll();
    }

    @GetMapping("/date/{createDate}")
    public Result<Collection<TestJpaEntity>> findByCreateDate(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate) {
        return this.demoClient.findByCreateDate(createDate);
    }
}
