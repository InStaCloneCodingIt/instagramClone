package org.insta.application.app.service;

import lombok.RequiredArgsConstructor;
import org.insta.application.app.dto.MemberDto;
import org.insta.application.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //@NotNull, final 붙은 필드들을 생성자를 만들어줍니다.
public class MemberServiceImpl implements MemberService{


    private final MemberMapper memberMapper;

    @Override
    public MemberDto findById(Integer id) {
        return memberMapper.findById(id);
    }
}
