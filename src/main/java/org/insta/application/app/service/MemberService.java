package org.insta.application.app.service;

import org.insta.application.app.dto.MemberDto;

public interface MemberService {

    MemberDto findById(Integer id);
}
