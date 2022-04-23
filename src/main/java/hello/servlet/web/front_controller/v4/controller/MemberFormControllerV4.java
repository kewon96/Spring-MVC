package hello.servlet.web.front_controller.v4.controller;

import hello.servlet.web.front_controller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        // 논리이름 이식(규칙은 직접설정)
        return "new-form";
    }
}
