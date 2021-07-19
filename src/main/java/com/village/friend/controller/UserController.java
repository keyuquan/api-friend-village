package com.village.friend.controller;

import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.UserDto;
import com.village.friend.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户模块")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册", httpMethod = "POST")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse<UserDto> register(RegisterDto param) {
        return userService.register(param);
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse<UserDto> login(@RequestBody LoginDto param) {
        return userService.login(param);
    }


}
