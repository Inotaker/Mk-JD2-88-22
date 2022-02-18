package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson.ICitizenService;
import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Citizen;
import by.it.academy.Mk_JD2_88_22.classwork.service.jackson.CitizenService;
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

@WebServlet(name = "GetCitizenForIdServlet", urlPatterns = "/getCitizen/*")
public class GetCitizenForIdServlet extends HttpServlet {
    private ObjectMapper mapper;
    private ICitizenService service;

    public GetCitizenForIdServlet() {
        this.mapper = new ObjectMapper();
        this.service = CitizenService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String[] urlDivide = req.getRequestURL().toString().split("/");
        writer.write(urlDivide[urlDivide.length - 1]);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        for (Citizen citizen : service.getCitizensList()) {
            if (citizen.getId().equals(urlDivide[urlDivide.length - 1])) {
                writer.write(gson.toJson(citizen));
            }
        }
    }
}
