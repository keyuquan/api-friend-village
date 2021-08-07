package com.village.friend.controller;

import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.request.SendAuthCodeDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.LoginResDto;
import com.village.friend.dto.response.RegisterResDto;
import com.village.friend.dto.response.SendAuthCodeResDto;
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

    @ApiOperation(value = "发送验证码", httpMethod = "POST")
    @RequestMapping(value = "/sendAuthCode", method = RequestMethod.POST)
    public BaseResponse<SendAuthCodeResDto> sendAuthCode(@RequestBody SendAuthCodeDto param) {
        return userService.sendAuthCode(param);
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse<LoginResDto> login(@RequestBody LoginDto param) {
        return userService.login(param);
    }

    @ApiOperation(value = "注册", httpMethod = "POST")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse<RegisterResDto> register(@RequestBody RegisterDto param) {
        return userService.register(param);
    }


}
