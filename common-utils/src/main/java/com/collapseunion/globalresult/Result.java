package com.collapseunion.globalresult;

import com.collapseunion.BeanUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.core.env.Environment;
import org.thymeleaf.util.StringUtils;

import java.io.Serializable;

/**
 * 统一结果返回类
 *
 * @author CloudSen
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -9031949034353264785L;
    /**
     * 额外数据
     */
    private T data;
    /**
     * 是否成功，true成功，false失败
     */
    private Boolean success;
    /**
     * 操作码，成功返回200
     */
    private String code;
    /**
     * 操作提示
     */
    private String message;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 提供者：当前为服务的名字
     */
    private String provider;

    public Result() {
    }

    public Result(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.provider = BeanUtil.getBean(Environment.class).getProperty("spring.application.name");
    }

    public Result(Boolean success, String code, String originStr, Object... objects) {
        this.success = success;
        this.code = code;
        String template = StringUtils.replace(originStr, "{}", "%s");
        this.message = String.format(template, objects);
        this.timestamp = System.currentTimeMillis();
        this.provider = BeanUtil.getBean(Environment.class).getProperty("spring.application.name");
    }

    public Result(Boolean success, T data, String code, String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.provider = BeanUtil.getBean(Environment.class).getProperty("spring.application.name");
    }

    public Result(Boolean success, T data, String code, String originStr, Object... objects) {
        this.success = success;
        this.data = data;
        this.code = code;
        String template = StringUtils.replace(originStr, "{}", "%s");
        this.message = String.format(template, objects);
        this.timestamp = System.currentTimeMillis();
        this.provider = BeanUtil.getBean(Environment.class).getProperty("spring.application.name");
    }
}
