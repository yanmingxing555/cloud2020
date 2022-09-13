package com.yss.springcloud.alibaba.fegin;

import com.yss.springcloud.entities.CommonResult;
import com.yss.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: ymx
 * @date: 2022/9/13
 * @description:
 * 如果想要获取异常信息，可以使用 fallbackFactory参数
 * 使用 fallback 方式是无法获取异常信息的，
 */
@FeignClient(value = "nacos-payment-provider",
        fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}

@Component
class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
