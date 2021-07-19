package com.village.friend.service.impl;

import com.village.friend.dto.request.AuthRequest;
import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.request.TestDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.constant.MsgCodeEnum;
import com.village.friend.dto.response.UserDto;
import com.village.friend.entity.User;
import com.village.friend.mapper.UserMapper;
import com.village.friend.service.IUserService;
import com.village.friend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public BaseResponse<UserDto> register(RegisterDto param) {
        User userByName = userMapper.findUserByName(param.getUsername());
        // 用户已注册
        if (userByName != null) {
            return new BaseResponse(MsgCodeEnum.REGISTER_EXISTING_ACCOUNT, null);
        }
        Integer integer = userMapper.addUser(param.getUsername(), param.getPassword(), param.getNickname(), param.getAvatarurl(), param.getPhone(), param.getMail(), param.getGender(), param.getBirth(), "", "");
        // 数据库插入失败
        if (integer < 1) {
            return new BaseResponse(MsgCodeEnum.SYSTEM_INNER_ERROR, null);
        }
        UserDto u = new UserDto(param.getUsername(), param.getNickname(), param.getAvatarurl(), "");
        return new BaseResponse(MsgCodeEnum.SUCCESS, u);
    }

    @Override
    public BaseResponse<UserDto> login(LoginDto param) {
        User user = userMapper.findUserByNamAndPwd(param.getUsername(), param.getPassword());
        // 账户或者密码错误
        if (user == null) {
            return new BaseResponse(MsgCodeEnum.LOGIN_ERROR_PWD, null);
        }
        String token = TokenUtils.token(user.getUsername(), user.getPassword());
        UserDto u = new UserDto(user.getUsername(), user.getNickname(), user.getAvatarurl(), token);
        return new BaseResponse(MsgCodeEnum.SUCCESS, u);
    }

    @Override
    public BaseResponse<UserDto> test(TestDto param) {
        return new BaseResponse(MsgCodeEnum.SUCCESS, null);
    }

    @Override
    public boolean auth(AuthRequest param) {
        return TokenUtils.verify(param.getUsername(), param.getToken());
    }
}
