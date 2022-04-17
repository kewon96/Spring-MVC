package hello.servlet.web.front_controller.v3.controller;

import hello.servlet.web.front_controller.ModelView;
import hello.servlet.web.front_controller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // 논리이름 이식(규칙은 직접설정)
        return new ModelView("new-form");
    }
}
