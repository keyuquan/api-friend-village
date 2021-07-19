package com.village.friend.service;

import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    BaseResponse<UserDto> register(RegisterDto param);

    BaseResponse<UserDto> login(LoginDto param);
}
