package com.village.friend.service.impl;

import com.village.friend.constant.MsgCodeEnum;
import com.village.friend.dto.request.AuthRequestDto;
import com.village.friend.dto.request.LoginDto;
import com.village.friend.dto.request.RegisterDto;
import com.village.friend.dto.request.SendAuthCodeDto;
import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.LoginResDto;
import com.village.friend.dto.response.RegisterResDto;
import com.village.friend.dto.response.SendAuthCodeResDto;
import com.village.friend.entity.AuthCodeEntity;
import com.village.friend.entity.UserEntity;
import com.village.friend.mapper.AuthCodeMapper;
import com.village.friend.mapper.UserMapper;
import com.village.friend.service.IUserService;
import com.village.friend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Value("${header.boy}")
    private String headerBoy;
    @Value("${header.girl}")
    private String headerGirl;
    @Value("${im.defaultPwd}")
    private String defaultPwd;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthCodeMapper authCodeMapper;

    @Override
    public BaseResponse<SendAuthCodeResDto> sendAuthCode(SendAuthCodeDto param) {
        // 生成随机验证码
        // String authCode = MathUtils.getAuthCode() + "";
        String authCode = "1234";
        // 发送验证码 @TODO
        // 把验证码入库
        authCodeMapper.addAuthCode(param.getPhone(), authCode, TokenUtils.token(param.getPhone(), authCode));
        return new BaseResponse(MsgCodeEnum.SUCCESS, null);
    }

    @Override
    public BaseResponse<RegisterResDto> register(RegisterDto param) {
        String usernameP = param.getUsername();
        String authCodeP = param.getAuthCode();
        UserEntity userEntity = userMapper.findUserByName(usernameP);
        // 该用户已注册
        if (userEntity != null) {
            return new BaseResponse(MsgCodeEnum.REGISTER_EXISTING_ACCOUNT, null);
        }
        AuthCodeEntity authCode = authCodeMapper.findByUsername(usernameP);
        // 验证码错误
        if (authCodeP == null || !authCodeP.equals(authCode.getAuthCode())) {
            return new BaseResponse(MsgCodeEnum.AUTH_CODE_ERROR, null);
        }
        // 注册成功
        Integer gender = param.getGender();
        // 默认头像
        //  男
        String avatarurl = headerBoy;
        //  女
        if (gender == 1) {
            avatarurl = headerGirl;
        }
        //1.数据写入mysql
        userMapper.addUser(usernameP, defaultPwd, "nickname", avatarurl, gender);
        // 2.数据同步到环信IM
        RegisterResDto data = new RegisterResDto(usernameP, authCode.getToken());
        return new BaseResponse(MsgCodeEnum.SUCCESS, data);
    }

    @Override
    public BaseResponse<LoginResDto> login(LoginDto param) {
        String usernameP = param.getUsername();
        String authCodeP = param.getAuthCode();
        UserEntity userEntity = userMapper.findUserByName(usernameP);
        // 该用户没有注册
        if (userEntity == null) {
            return new BaseResponse(MsgCodeEnum.LOGIN_BEFORE_REGISTER, null);
        }
        AuthCodeEntity authCode = authCodeMapper.findByUsername(usernameP);
        // 验证码错误
        if (authCodeP == null || !authCodeP.equals(authCode.getAuthCode())) {
            return new BaseResponse(MsgCodeEnum.AUTH_CODE_ERROR, null);
        }
        // 登录成功
        LoginResDto data = new LoginResDto(usernameP, authCode.getToken());
        return new BaseResponse(MsgCodeEnum.SUCCESS, data);

    }

    @Override
    public boolean auth(AuthRequestDto param) {
        String usernameP = param.getUsername();
        String tokenP = param.getToken();
        AuthCodeEntity authCode = authCodeMapper.findByUsername(usernameP);
        if (tokenP == null || !tokenP.equals(authCode.getToken())) {
            // 验证码错误
            return false;
        }
        return true;
    }
}
