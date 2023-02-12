package org.insta.application.app.controller;


import lombok.RequiredArgsConstructor;
import org.insta.application.app.dto.MemberDto;
import org.insta.application.app.service.Actor;
import org.insta.application.app.service.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @Qualifier(value = "second")
    private final Actor actor;

    @GetMapping("/index")
    public MemberDto index(Integer id) {
        MemberDto result = memberService.findById(id);
        return result;
    }

    @GetMapping("/musical")
    public void index2 () {
        actor.manActor();
        actor.womanActor();
    }

}
