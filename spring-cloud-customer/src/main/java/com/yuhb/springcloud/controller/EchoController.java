package com.yuhb.springcloud.controller;

import com.yuhb.springcloud.interfaces.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EchoController {

    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "/echo")
    public String echo(String name) {
        return echoService.echo(name);
    }
}
