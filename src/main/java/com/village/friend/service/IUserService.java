package com.village.friend.service;

import com.village.friend.dto.request.*;
import com.village.friend.dto.response.RegisterResDto;
import com.village.friend.dto.response.SendAuthCodeResDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.LoginResDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    // 发送验证码
    BaseResponse<SendAuthCodeResDto> sendAuthCode(SendAuthCodeDto param);

    // 注册
    BaseResponse<RegisterResDto> register(RegisterDto param);

    // 登录
    BaseResponse<LoginResDto> login(LoginDto param);

    //  token 验证
    boolean auth(AuthRequestDto param);
}
