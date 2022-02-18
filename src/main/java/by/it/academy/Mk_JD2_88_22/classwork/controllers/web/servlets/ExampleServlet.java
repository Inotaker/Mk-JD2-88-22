package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets;

import by.it.academy.Mk_JD2_88_22.classwork.dto.person.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExampleServlet", urlPatterns = "/test")
public class ExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Person person = new Person("Alex", "Hahl", 22);
        req.setAttribute("user", person);

        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
    }
}
