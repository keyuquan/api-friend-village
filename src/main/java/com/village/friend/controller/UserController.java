package com.village.friend.controller;

import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.response.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import com.village.friend.dto.response.UserDto;

@Controller
@RequestMapping("/api/user")
@Api(tags = "用户模块")
public class UserController {

    @ApiOperation(value = "注册", httpMethod = "POST")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseBase<UserDto> register(@RequestBody RegisterDto param) {

        return null;
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseBase<UserDto> login(@RequestBody Map<String, String> param) {
        return null;
    }


}
