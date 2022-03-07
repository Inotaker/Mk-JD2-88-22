package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.polls;

import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class PollPost extends HttpServlet {
    IPollService service;
    ObjectMapper mapper;

    public PollPost() {
        this.service = PollService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Poll poll = mapper.readValue(req.getInputStream(), Poll.class);
        this.service.creatPoll(poll);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

    }
}
