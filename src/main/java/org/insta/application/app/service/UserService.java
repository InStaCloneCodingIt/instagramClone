package org.insta.application.app.service;


import org.insta.application.app.dto.User;

public interface UserService {

    User findById(int id);
}
