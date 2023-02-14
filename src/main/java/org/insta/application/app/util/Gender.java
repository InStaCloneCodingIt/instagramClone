package org.insta.application.app.util;

import lombok.Getter;

@Getter
public enum Gender {
    MAN("남자"),
    WOMAN("여자");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public static Gender get(String code) {
        for (Gender element : values()) {
            if (element.getDescription().equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }
    public static Gender lookup(String code) {
        for (Gender element : Gender.values()) {
            if (element.getDescription().equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }
}
