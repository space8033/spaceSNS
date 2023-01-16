package com.space.sns.service;

import com.space.sns.exception.ErrorCode;
import com.space.sns.exception.SnsApplicationException;
import com.space.sns.model.User;
import com.space.sns.model.entity.UserEntity;
import com.space.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public User join(String userName, String password) {
        //회원가입 아이디가 이미 있는지 확인
        userEntityRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", userName));
        });
        //회원가입 진행
        UserEntity userEntity = userEntityRepository.save(UserEntity.of(userName, encoder.encode(password)));

        return User.fromEntity(userEntity);
    }

    public String login(String userName, String password) {
        //회원가입 여부 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME,""));
        //비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
        }
        //토큰 생성
        return "";
    }
}
