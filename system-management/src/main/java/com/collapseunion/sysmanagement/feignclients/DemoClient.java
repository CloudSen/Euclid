package com.collapseunion.sysmanagement.feignclients;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * feign测试客户端
 *
 * @author CloudSen
 */
@FeignClient(name = "demo-for-test")
public interface DemoClient {

    /**
     * 查询所有的Test内容
     *
     * @return 所有的Test内容
     */
    @GetMapping("/jpa-test/")
    Result<Collection<TestJpaEntity>> findAll();
}
