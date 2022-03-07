package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.polls;

import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;
import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.SavedPoll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;


@WebServlet(name = "PoolResultServlet", urlPatterns = "/pool_result")
public class PollResultServlet extends HttpServlet {

    private IPollService pollService = PollService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p>Количество голосов и информаци о них: " + pollService.getPolls().size() + "</p></br>");
        for (SavedPoll pool : ChoiceWithCount.getPoolsModified()) {
            writer.write("</p>" + pool.toString() + "</p>");
            writer.write("<p></p>");
        }
        writer.write("<p>Артисты отсортированные по количеству голосов</p>");
        writer.write("<p>" + ChoiceWithCount.getPerformerTop() + "</p>");
        writer.write("<p></p>");
        writer.write("<p>Жанры отсортированные по количеству голосов</p>");
        writer.write("<p>" + ChoiceWithCount.getGenresTop() + "</p>");
        writer.write("<p></p>");

        Comparator<SavedPoll> comparator = new Comparator<SavedPoll>() {
            @Override
            public int compare(SavedPoll o1, SavedPoll o2) {
                if (o1.getTime().isBefore(o2.getTime())) {
                    return -1;
                } else if (o1.getTime().isAfter(o2.getTime())) {
                    return 1;
                } else return 0;
            }
        };
        writer.write("<p>Голоса отсортированные по времени отправки голоса</p>");
        ChoiceWithCount.getPoolsModified().sort(comparator);
        for (SavedPoll pool : ChoiceWithCount.getPoolsModified()) {
            writer.write("<p>" + pool.toString() + "</p>");
        }
    }


}