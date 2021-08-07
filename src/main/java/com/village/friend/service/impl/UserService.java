package com.village.friend.service.impl;

import com.village.friend.dto.request.*;
import com.village.friend.dto.response.SendAuthCodeResDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.constant.MsgCodeEnum;
import com.village.friend.dto.response.LoginResDto;
import com.village.friend.dto.response.UserDto;
import com.village.friend.entity.User;
import com.village.friend.mapper.AuthCodeMapper;
import com.village.friend.mapper.UserMapper;
import com.village.friend.service.IUserService;
import com.village.friend.utils.MathUtils;
import com.village.friend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthCodeMapper authCodeMapper;


    @Override
    public BaseResponse<SendAuthCodeResDto> sendAuthCode(SendAuthCodeDto param) {
        // 生成随机验证码
        // String authCode = MathUtils.getAuthCode() + "";
        String authCode = "1234";
        //  发送验证码 @TODO
        // 把验证码入库
        authCodeMapper.addAuthCode(param.getPhone(), authCode, TokenUtils.token(param.getPhone(), authCode));
        return new BaseResponse(MsgCodeEnum.SUCCESS, null);
    }

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
    public BaseResponse<LoginResDto> login(LoginDto param) {
        User user = userMapper.findUserByName(param.getUsername());
        if (user == null) {
            // 用户不存在，需要注册
            return new BaseResponse(MsgCodeEnum.LOGIN_BEFORE_REGISTER, null);
        }
        String token = TokenUtils.token(user.getUsername(), user.getPassword());
        LoginResDto data = new LoginResDto(user.getUsername(), token);
        return new BaseResponse(MsgCodeEnum.SUCCESS, data);
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
