package com.example.aboutbook;

import com.example.aboutbook.global.exception.ApiResponse;
import com.example.aboutbook.user.dto.UserReq;
import com.example.aboutbook.user.dto.UserRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name="Test❤", description = "Test Api")
@RequestMapping("/test")
public class TestController {

    @GetMapping
    @Operation(summary = "테스트", description = "테스트!")
    public ApiResponse<String> signup() throws Exception {
        try{
            return new ApiResponse<>("test 완.");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
