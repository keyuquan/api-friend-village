package com.village.friend.controller;

import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.MsgCodeEnum;
import com.village.friend.dto.response.UserDto;
import com.village.friend.entity.User;
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
    @RequestMapping(value = "/register")
    public BaseResponse<UserDto> register(RegisterDto param) {
        User user = new User(param.getName(), param.getPwd(), param.getAge(), param.getSex(), param.getBirthday());
        User userByName = userService.findUserByName(user.getName());
        // 账户已存在
        if (userByName != null) {
            return resp(MsgCodeEnum.REGISTER_EXISTING_ACCOUNT, null);
        }
        Integer count = userService.addUser(user);
        // 数据库插入失败
        if (count < 1) {
            return resp(MsgCodeEnum.SYSTEM_INNER_ERROR, null);
        }
        UserDto userDto = new UserDto(user.getName(), user.getBirthday());
        return resp(MsgCodeEnum.SUCCESS, userDto);
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse<UserDto> login(@RequestBody LoginDto param) {
        User userByName = userService.findUserByNamAndPwd(param.getName(), param.getPwd());
        if (userByName == null) {
            return resp(MsgCodeEnum.LOGIN_ERROR_PWD, null);
        }
        UserDto userDto = new UserDto(userByName.getName(), userByName.getBirthday());
        return resp(MsgCodeEnum.SUCCESS, userDto);
    }


}
