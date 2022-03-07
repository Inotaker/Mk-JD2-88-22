package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.airport;

import by.it.academy.Mk_JD2_88_22.classwork.dto.airports.Airport;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.airports.AirportService;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.airports.IAirportService;
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

@WebServlet(name = "AirportServlet", urlPatterns = "/booking/airports")
public class AirportServlet extends HttpServlet {

    private IAirportService airportService;
    private ObjectMapper mapper;

    public AirportServlet() {
        this.airportService = AirportService.getInstance();
        this.mapper = new ObjectMapper();

        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        mapper.registerModule(module);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        int page;
        String pageRaw = req.getParameter("page");
        if(pageRaw == null || pageRaw.isEmpty()){
            page = 1;
        } else {
            page = Integer.parseInt(pageRaw);
        }

        int size;
        String sizeRaw = req.getParameter("size");
        if(sizeRaw == null || sizeRaw.isEmpty()){
            size = 20;
        } else {
            size = Integer.parseInt(sizeRaw);
        }

        List<Airport> airports = airportService.getList(page, size);

        writer.write(mapper.writeValueAsString(airports));
    }
}
