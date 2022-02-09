package by.it.academy.Mk_JD2_88_22.controllers.web.servlets.jackson.students;

import by.it.academy.Mk_JD2_88_22.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetStudentsServlet", urlPatterns = "/students")
public class GetStudentsServlet extends HttpServlet {
    StudentService service;
    ObjectMapper mapper;

    public GetStudentsServlet() {
        this.mapper = new ObjectMapper();
        this.service = StudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        writer.write(gson.toJson(service.getStudentsList()));

    }
}
