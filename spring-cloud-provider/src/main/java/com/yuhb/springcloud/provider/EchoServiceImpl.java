package com.yuhb.springcloud.provider;

import com.yuhb.springcloud.domain.SysUser;
import com.yuhb.springcloud.interfaces.EchoService;
import com.yuhb.springcloud.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoServiceImpl implements EchoService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser echo(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
