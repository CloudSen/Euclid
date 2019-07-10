package com.collapseunion.sysmanagement.feignclients.fallback;

import com.collapseunion.commonapi.entity.TestJpaEntity;
import com.collapseunion.commonutils.globalresult.Result;
import com.collapseunion.commonutils.globalresult.ResultUtil;
import com.collapseunion.sysmanagement.SysManagementApplication;
import com.collapseunion.sysmanagement.feignclients.DemoClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Feign客户端使用断路器
 *
 * @author CloudSen
 */
@Slf4j
@Component
public class DemoClientFallbackFactory implements FallbackFactory<DemoClient> {
    @Override
    public DemoClient create(Throwable throwable) {
        return new DemoClient() {
            @Override
            public Result<Collection<TestJpaEntity>> findAll() {
                log.error("触发断路器，异常信息{}", throwable.getMessage());
                List<TestJpaEntity> errorData = Arrays.asList(
                        new TestJpaEntity().setName("null data").setCreateDate(new Date()).setId(UUID.randomUUID().toString()),
                        new TestJpaEntity().setName("error").setCreateDate(new Date()).setId(UUID.randomUUID().toString()));
                return ResultUtil.error(errorData, throwable.getMessage(), SysManagementApplication.APPLICATION_NAME);
            }

            @Override
            public Result<Collection<TestJpaEntity>> findByCreateDate(Date createDate) {
                return null;
            }
        };
    }
}
