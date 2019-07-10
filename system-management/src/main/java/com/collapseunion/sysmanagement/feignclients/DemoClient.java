package com.collapseunion.sysmanagement.feignclients;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import com.collapseunion.sysmanagement.feignclients.fallback.DemoClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Date;

/**
 * feign测试客户端
 *
 * @author CloudSen
 */
@FeignClient(name = "demo-for-test", fallbackFactory = DemoClientFallbackFactory.class)
public interface DemoClient {

    /**
     * 查询所有的Test内容
     *
     * @return 所有的Test内容
     */
    @GetMapping("/jpa-test/")
    Result<Collection<TestJpaEntity>> findAll();

    /**
     * 根据创建日期查询
     *
     * @param createDate 创建日期
     * @return 某个日期的test内容
     */
    @GetMapping("/jpa-test/date/{createDate}")
    Result<Collection<TestJpaEntity>> findByCreateDate(@PathVariable("createDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date createDate);
}
