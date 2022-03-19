package hello.servlet.basic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class HelloData {

    private String username;
    private int age;

}
