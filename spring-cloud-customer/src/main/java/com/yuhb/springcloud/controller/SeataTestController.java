package com.yuhb.springcloud.controller;

import com.yuhb.springcloud.domain.SysUser;
import com.yuhb.springcloud.interfaces.EchoService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-06-02
 */
@RestController
public class SeataTestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeataTestController.class);

    @Autowired
    private EchoService echoService;

    @GlobalTransactional
    @RequestMapping(value = "/seata/rollback")
    private String rollback(Integer age,String name,boolean fail) {
        LOGGER.info("全局事务id: {}", RootContext.getXID());

        SysUser sysUser = new SysUser();
        sysUser.setAge(age);
        sysUser.setName(name);
        echoService.save(sysUser);

        if (fail) {
            throw new RuntimeException("全局异常回滚");
        }
        return "success";
    }

}
