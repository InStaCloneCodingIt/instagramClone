package org.insta.application.app.dto;

import lombok.*;
import org.insta.application.app.util.Gender;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 기본 생성자의 접근 제어를 PROTECTED로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단이 된다.
// 예를 들어 User라는 Class는 name, age, email 정보를 모두 가지고있어야만 되는 상황일경우에
// 기본 생성자를 막는것은 이를 도와주는 좋은 수단
public class User {
    private int userId;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private LocalDateTime birth;
    private String name;
    private String nickname;
    private String website;
    private String introduce;
    private String profileImage;

    @Builder
    public User(int userId, String email, String password, String phone, Gender gender, LocalDateTime birth, String name, String nickname, String website, String introduce, String profileImage) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.birth = birth;
        this.name = name;
        this.nickname = nickname;
        this.website = website;
        this.introduce = introduce;
        this.profileImage = profileImage;
    }
}
