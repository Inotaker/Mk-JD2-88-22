package by.it.academy.Mk_JD2_88_22.endpoints.servlets;

import by.it.academy.Mk_JD2_88_22.listeners.SessionListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountSessionServlet", urlPatterns = "/count_session")
public class CountSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int countSession = SessionListener.getCountSession();
        writer.write("Sessions created: " + countSession);
    }
}
