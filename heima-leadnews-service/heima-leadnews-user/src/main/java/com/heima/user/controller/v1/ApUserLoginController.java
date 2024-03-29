package com.heima.user.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dto.LoginDto;
import com.heima.user.service.ApUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/login")
@Api(value = "app端用户登录",tags = "app端用户登录")
public class ApUserLoginController {
    @Autowired
    private ApUserService apUserService;

    @RequestMapping("/login_auth")
    @ApiOperation("用户登录")
    public ResponseResult login(@RequestBody LoginDto dto){
        return apUserService.login(dto);
    }
}
