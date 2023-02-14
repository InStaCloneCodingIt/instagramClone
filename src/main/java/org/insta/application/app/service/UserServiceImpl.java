package org.insta.application.app.service;

import lombok.RequiredArgsConstructor;
import org.insta.application.app.dto.User;
import org.insta.application.app.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //@NotNull, final 붙은 필드들을 생성자를 만들어줍니다.
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public User findById(int id) {
        User user = userMapper.findById(id);
        return user;
    }
}
