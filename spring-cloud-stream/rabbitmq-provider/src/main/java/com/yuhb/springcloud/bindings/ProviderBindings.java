package com.yuhb.springcloud.bindings;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-05-19
 */

public interface ProviderBindings {
    String CUS_OUT1 = "cus-output1";

    @Output(ProviderBindings.CUS_OUT1)
    MessageChannel output1();
}
