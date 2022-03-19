package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. parameter 전송기능
 * http://hocalhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("전체 Paramter 조회");

        Enumeration<String> parameterNames = request.getParameterNames();
        parameterNames.asIterator().forEachRemaining(p -> System.out.println(p + " : " + request.getParameter(p)));

        System.out.println("전체 Parameter 조회 끝");
        System.out.println();

        System.out.println("단일 Parameter 조회");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println(username + " / " + age);

        System.out.println("이름이 같은 중복 Parameter 조회");
        String[] usernames = request.getParameterValues("username");
        for(String u : usernames) {
            System.out.println(u);
        }

        response.getWriter().write("OK!");
        
    }
}
