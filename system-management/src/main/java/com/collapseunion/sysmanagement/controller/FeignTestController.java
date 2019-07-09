package com.collapseunion.sysmanagement.controller;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import com.collapseunion.sysmanagement.feignclients.DemoClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
        return demoClient.findAll();
    }
}
