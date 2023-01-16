package com.space.sns.service;

import com.space.sns.exception.ErrorCode;
import com.space.sns.exception.SnsApplicationException;
import com.space.sns.model.entity.PostEntity;
import com.space.sns.repository.PostEntityRepository;
import com.space.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {
        userEntityRepository.findByUserName(userName).orElseThrow(()
                -> new SnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        postEntityRepository.save(new PostEntity());
    }
}
