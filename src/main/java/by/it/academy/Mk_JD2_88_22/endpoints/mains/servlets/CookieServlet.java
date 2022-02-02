package by.it.academy.Mk_JD2_88_22.endpoints.mains.servlets;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Cookie[] cookies = req.getCookies();
        if (firstName != null) {
            Cookie cookieFirstName = new Cookie("firstName", firstName);
            resp.addCookie(cookieFirstName);
        } else {
            try {
                firstName = cookies[0].getValue();
            }
            catch (Exception e) {
                writer.write(e.getMessage());
            }
        }
        if (lastName != null) {
            Cookie cookieLastName = new Cookie("lasTName", lastName);
            resp.addCookie(cookieLastName);
        } else {
            try {
                lastName = cookies[1].getValue();
            }
            catch (Exception e) {
                writer.write(e.getMessage());
            }
        }

        writer.write("<p>Hello, " + firstName + " " + lastName);

    }
}
