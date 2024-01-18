package com.example.aboutbook.global.config;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Notice", description = "FCM Notification 관련 api")
@RequiredArgsConstructor
@RestController
@RequestMapping("notice")
public class FCMController {

    private final FCMService fcmService;

    @PostMapping
    public String sendNotificationByToken(@RequestBody FCMRequestDto fcmRequestDto) {
        return fcmService.sendNotificationByToken(fcmRequestDto);
    }
}
