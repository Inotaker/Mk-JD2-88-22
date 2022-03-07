package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.jackson;

import by.it.academy.Mk_JD2_88_22.classwork.dto.jackson.Citizen;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.jackson.ICitizenService;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.jackson.CitizenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CitizenServlet", urlPatterns = "/citizens")
public class CitizenServlet extends HttpServlet {
    private ObjectMapper mapper;
    private ICitizenService service;

    public CitizenServlet() {
        this.mapper = new ObjectMapper();
        this.service = CitizenService.getInstance();

        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer((DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        mapper.registerModule(module);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        List<Citizen> storage = service.getCitizensList();

        writer.write(mapper.writeValueAsString(storage));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Citizen citizen = mapper.readValue(req.getInputStream(), Citizen.class);
        service.addCitizen(citizen);
    }
}
