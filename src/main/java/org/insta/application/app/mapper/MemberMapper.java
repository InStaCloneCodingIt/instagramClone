package org.insta.application.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.insta.application.app.dto.MemberDto;

@Mapper
public interface MemberMapper {

    MemberDto findById (Integer id);

}
