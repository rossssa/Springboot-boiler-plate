package com.example.aboutbook.global.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FCMRequestDto {
    private Long userId;
    private String title;
    private String body;
   // private String image;
   // private Map<String, String> data;


}
