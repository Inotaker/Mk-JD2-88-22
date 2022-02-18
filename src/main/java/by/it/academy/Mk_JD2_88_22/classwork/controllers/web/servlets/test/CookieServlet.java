package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    private static final String PARAMETER_FIRST_NAME = "firstName";
    private static final String PARAMETER_LAST_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String firstName = req.getParameter(PARAMETER_FIRST_NAME);
        String lastName = req.getParameter(PARAMETER_LAST_NAME);

        if (firstName == null) {
            firstName = getCookiesValue(PARAMETER_FIRST_NAME, req);
            if (firstName == null) {
                throw new IllegalArgumentException("Параметр имени отсутствует");
            }
        } else {
            saveCookies(PARAMETER_FIRST_NAME, firstName, resp);
        }

        if (lastName == null) {
            lastName = getCookiesValue(PARAMETER_LAST_NAME, req);
            if (lastName == null) {
                throw new IllegalArgumentException("Параметр фамилии отсутствует");
            }
        } else {
            saveCookies(PARAMETER_LAST_NAME, lastName, resp);
        }
        writer.write("Hello " + firstName + " " + lastName);
    }

    private String getCookiesValue(String cookiesName, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookiesName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private void saveCookies(String cookiesName, String value, HttpServletResponse resp) {
        Cookie cookie = new Cookie(cookiesName, value);
        resp.addCookie(cookie);
    }

}
