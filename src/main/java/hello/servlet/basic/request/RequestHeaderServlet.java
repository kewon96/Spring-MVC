package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        printRequest(request);
//        printHeaders(request);
        printHeaderUtils(request);
//        printEtc(request);
    }

    /**
     * <pre>
     *  getMethod : 요청으로 넘어온 METHOD방식(GET)
     *  getProtocal : protocal(HTTP/1.1)
     *  getScheme : 규칙(http)
     *  getRequestURL : 전체 URL(http://localhost:8080/request-header)
     *  getRequestURI : 해당하는 요청의 URL(/request-header)
     *  getQueryString : GET방식으로 넘어왔을 때 URL뒤에 붙어오는 데이터
     *  isSecure : https 여부
     *  @param request
     *
     * </pre>
     */
    private void printRequest(HttpServletRequest request) {
        System.out.println("--- Request Line Start ---");

        System.out.println("method : " + request.getMethod());
        System.out.println("protocal : " + request.getProtocol());
        System.out.println("scheme : " + request.getScheme());
        System.out.println("request url : " + request.getRequestURL());
        System.out.println("request uri : " + request.getRequestURI());
        System.out.println("queryString : " + request.getQueryString());
        System.out.println("isSecure : " + request.isSecure());

        System.out.println("--- Request Line End ---");
        System.out.println();
    }

    /**
     * 모든 header정보 가져오기
     * @param request
     */
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers Start ---");


        /* 방법 1 : while
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("headerName : " + headerName);
        }*/

        // 방법 2 : convert Iterator
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println("headerName : " + headerName));

        System.out.println("--- Headers End ---");
        System.out.println();
    }

    // Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");

        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " +
                request.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");

        System.out.println();
    }

    /**
     * 기타정보
     * 내부적으로 네트워크연결에 대한 정보(요청에 의해 넘어온 정보가 아님)
     * @param request
     */
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");

        // 요청이 온 것에 대한 정보
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();

        // 나의 서버 정보
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //

        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
