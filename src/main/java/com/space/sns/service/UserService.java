package com.space.sns.service;

import com.space.sns.exception.SnsApplicationException;
import com.space.sns.model.User;
import com.space.sns.model.entity.UserEntity;
import com.space.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User join(String userName, String password) {
        //회원가입 아이디가 이미 있는지 확인
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException();
        });
        //회원가입 진행
        UserEntity userEntity = userRepository.save(UserEntity.of(userName, password));

        return new User();
    }

    public String login(String userName, String password) {
        //회원가입 여부 체크
        UserEntity userEntity = userRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());
        //비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }
        //토큰 생성
        return "";
    }
}
