package com.yuhb.springcloud.binder;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-05-19
 */
public interface CustomerSink {

     String CUS_INPT_1 = "cus-input1";

     String CUS_INPT_2 = "cus-input2";

    @Input(CustomerSink.CUS_INPT_1)
    SubscribableChannel cusInput1();

    @Input(CustomerSink.CUS_INPT_2)
    SubscribableChannel cusInput2();


}
