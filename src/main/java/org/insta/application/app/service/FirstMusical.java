package org.insta.application.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
@Qualifier(value = "first")
public class FirstMusical implements Actor{

    @Override
    public void manActor() {
        String man = "전기";
    }

    @Override
    public void womanActor() {
        String woman = "한혜진";
    }
}
