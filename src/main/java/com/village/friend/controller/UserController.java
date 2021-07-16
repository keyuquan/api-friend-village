package com.village.friend.controller;

import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.MsgCodeEnum;
import com.village.friend.dto.response.ResponseBase;
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

import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Api(tags = "用户模块")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册", httpMethod = "POST")
    @RequestMapping(value = "/register")
    public BaseResponse<UserDto> register(RegisterDto param) {
        User user = new User(param.getUserName(), param.getPwd(), param.getAge(), param.getSex(), param.getBirthday());
        User userByName = userService.findUserByName(user.getName());
        // 账户已存在
        if (userByName != null) {
            return new BaseResponse<>(MsgCodeEnum.REGISTER_EXISTING_ACCOUNT, null);
        }
        User user1 = userService.addUser(user);
        return retSuccess(new UserDto(user.getName(), user.getBirthday()));
    }

    @ApiOperation(value = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseBase<UserDto> login(@RequestBody Map<String, String> param) {
        return null;
    }


}
