package by.it.academy.Mk_JD2_88_22.controllers.web.servlets.jackson.students;

import by.it.academy.Mk_JD2_88_22.service.StudentService;
import by.it.academy.Mk_JD2_88_22.service.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PostStudentsServlet", urlPatterns = "/createStudent")
public class PostStudentsServlet extends HttpServlet {
    StudentService service;
    ObjectMapper mapper;

    public PostStudentsServlet() {
        this.mapper = new ObjectMapper();
        this.service = StudentService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        Student student = mapper.readValue(req.getInputStream(), Student.class);
        service.addStudent(student);
        writer.write(student.toString());
    }
}
