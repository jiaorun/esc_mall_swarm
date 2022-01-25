package com.esc.mall.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.esc.mall.domain.CommonResult;
import com.esc.mall.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试限流和熔断 控制层
 *
 * @author jiaorun
 * @date 2022/1/25 14:57
 **/
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     *
     * @author jiaorun
     * @data 2022/1/25 15:03
     * @return com.esc.mall.domain.CommonResult
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流");
    }

    /**
     * 按URL限流，有默认的限流处理逻辑
     *
     * @author jiaorun
     * @data 2022/1/25 15:06
     * @return com.esc.mall.domain.CommonResult
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "handleException")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流");
    }

    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandler = "handleException", blockHandlerClass = CustomBlockHandler.class)
    public CommonResult blockHandler() {
        return new CommonResult(200, "限流成功");
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(200, exception.getClass().getCanonicalName());
    }
}
