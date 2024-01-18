package com.example.aboutbook.global.config;

import com.example.aboutbook.user.entity.User;
import com.example.aboutbook.user.repository.UserRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FCMService {

    private final FirebaseMessaging firebaseMessaging;
    private final UserRepository userRepository;

    public String sendNotificationByToken(FCMRequestDto requestDto) {
        Optional<User> user = userRepository.findById(requestDto.getUserId());

        if(user.isPresent()) {
            if(user.get().getDeviceToken() != null) {
                Notification notification = Notification.builder()
                        .setTitle(requestDto.getTitle())
                        .setBody(requestDto.getBody())
                       // .setImage(requestDto.getImage())
                        .build();
                Message message = Message.builder()
                        .setToken(user.get().getDeviceToken())
                        .setNotification(notification)
                       // .putAllData(requestDto.getData())
                        .build();

                try {
                    firebaseMessaging.send(message);
                    return "알림을 성공적으로 전송했습니다. targetUserId=" + requestDto.getUserId();
                } catch (FirebaseMessagingException e) {
                    e.printStackTrace();
                    return "알림 보내기를 실패하였습니다. targetUserId=" + requestDto.getUserId();
                }
            }
            else {
                return " 서버에 저장된 해당 유저의 FirebaseToken이 존재하지 않습니다.";
            }
        } else {
            return "해당 유저가 존재하지 않습니다.";
        }
    }

}
