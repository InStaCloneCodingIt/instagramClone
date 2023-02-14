package org.insta.application.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.insta.application.app.dto.User;

@Mapper
public interface UserMapper {

    User findById (int id);

}
