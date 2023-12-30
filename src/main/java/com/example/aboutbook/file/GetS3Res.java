package com.example.aboutbook.file;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetS3Res {
    private String imgUrl;
    private String fileName;
}
