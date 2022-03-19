package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // status-line
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        // response-header
        content(response);
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello!"); // custom header

        // response-body
        PrintWriter writer = response.getWriter();
        writer.println("됐어!!");
    }

    /**
     * Content-Type: text/plain;charset=utf-8
     * Content-Length: 3
     * @param response
     */
    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    /**
     * Set-Cookie: myCookie=good; Max-Age=600;
     * response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
     * @param response
     */
    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    /**
     * Status Code 302
     * Location: /basic/hello-form.html
     * @param response
     * @throws IOException
     */
    private void redirect(HttpServletResponse response) throws IOException {
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
