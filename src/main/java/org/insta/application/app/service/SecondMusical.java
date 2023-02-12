package org.insta.application.app.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "second")
public class SecondMusical implements Actor{

    @Override
    public void manActor() {
        String a = "재열";
    }

    @Override
    public void womanActor() {
        String b = "김영한";
    }
}
