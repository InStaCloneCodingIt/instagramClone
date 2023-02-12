package org.insta.application.app.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Gender {
    MAN("남자"),
    WOMAN("여자");

    private String description;

    Gender(String description) {
        this.description = description;
    }
}
