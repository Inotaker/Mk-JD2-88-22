package by.it.academy.Mk_JD2_88_22.endpoints.mains.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    private static final String PARAMETER_FIRST_NAME = "firstName";
    private static final String PARAMETER_LAST_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();

        String firstName = req.getParameter(PARAMETER_FIRST_NAME);
        if (firstName == null) {
            firstName = (String) session.getAttribute(PARAMETER_FIRST_NAME);
            if (firstName == null) {
                throw new IllegalArgumentException("Не передан параметр");
            }
        } else {
            session.setAttribute(PARAMETER_FIRST_NAME, firstName);
        }


        String lastName = req.getParameter(PARAMETER_LAST_NAME);
        if (lastName == null) {
            lastName = (String) session.getAttribute(PARAMETER_LAST_NAME);
            if (lastName == null) {
                throw new IllegalArgumentException("Не передан параметр");
            }
        } else {
            session.setAttribute(PARAMETER_LAST_NAME, lastName);
        }
        writer.write("<p>Hello, " + firstName + " " + lastName + "</p>");
    }
}
