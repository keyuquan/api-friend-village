package com.village.friend.service;

import com.village.friend.dto.request.*;
import com.village.friend.dto.response.SendAuthCodeResDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.LoginResDto;
import com.village.friend.dto.response.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    // 发送验证码
    BaseResponse<SendAuthCodeResDto> sendAuthCode(SendAuthCodeDto param);

    // 注册
    BaseResponse<UserDto> register(RegisterDto param);

    // 登录
    BaseResponse<LoginResDto> login(LoginDto param);

    // 测试
    BaseResponse<UserDto> test(TestDto param);

    //  token 验证
    boolean auth(AuthRequest param);
}
