package com.esc.mall.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.esc.mall.domain.CommonResult;

/**
 * 自定义限流处理逻辑
 *
 * @author jiaorun
 * @date 2022/1/25 15:17
 **/
public class CustomBlockHandler {

    public CommonResult handlerException(BlockException exception) {
        return new CommonResult(200, "自定义限流信息");
    }
}
