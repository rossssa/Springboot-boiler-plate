package com.example.aboutbook.user.controller;

import com.example.aboutbook.global.exception.ApiResponse;
import com.example.aboutbook.user.dto.Token;
import com.example.aboutbook.user.dto.UserReq;
import com.example.aboutbook.user.dto.UserRes;
import com.example.aboutbook.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name="User❤", description = "User 관련 Api")
@RequestMapping("/jwt")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "자체 회원가입", description = "자체 회원가입")
    public ApiResponse<UserRes.SignUpRes> signup(@RequestBody UserReq.SignUpReq signUpReq) throws Exception {
        try{
            return new ApiResponse<>(userService.signup(signUpReq));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/login")
    @Operation(summary = "자체 로그인", description = "자체 로그인")
    public ApiResponse<Token> login(@RequestBody UserReq.LoginReq loginReq) throws Exception {
        try{
            return new ApiResponse<>(userService.login(loginReq));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
