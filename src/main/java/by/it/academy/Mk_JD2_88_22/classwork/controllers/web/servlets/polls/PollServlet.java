package by.it.academy.Mk_JD2_88_22.classwork.controllers.web.servlets.polls;

import by.it.academy.Mk_JD2_88_22.classwork.dto.polls.Poll;
import by.it.academy.Mk_JD2_88_22.classwork.service.api.pool.IPollService;
import by.it.academy.Mk_JD2_88_22.classwork.service.service.pool.PollService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebListener
@WebServlet(name = "PoolServlet", urlPatterns = "/pool")
public class PollServlet extends HttpServlet implements ServletContextListener {


    private static String NAME_PARAMETER_HEADER = "PERFORMER_POOL";
    private static String NAME_PARAMETER_HEADER_SECOND = "GENRE_POOL";
    private static String NAME_PARAMETER_HEADER_THIRD = "ABOUT_ME";

    private IPollService pollService = PollService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> artists = pollService.getArtists();
        List<String> genres = pollService.getGenres();


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        String headerPoolPerformer = req.getHeader(NAME_PARAMETER_HEADER);
        String[] poolsPerformer = req.getParameterMap().get(headerPoolPerformer);

        if (poolsPerformer != null) {
            writer.write("<p> Ваш голос был отдан за " + artists.get(Integer.parseInt(poolsPerformer[0]) - 1) + "</p>");//вау!
        }

        String headerPoolGenres = req.getHeader(NAME_PARAMETER_HEADER_SECOND);
        String[] poolsGenres = req.getParameterMap().get(headerPoolGenres);

        if (poolsGenres.length == 3) {
            writer.write("<p>Вы отдали голос за жанры : ");
            for (int i = 0; i < poolsGenres.length; i++) {
                int a = Integer.parseInt(poolsGenres[i]);
                writer.write(a + "." + genres.get(a - 1) + ", ");
            }
            writer.write("</p>");
        }


        String headerAboutUser = req.getHeader(NAME_PARAMETER_HEADER_THIRD);
        String[] aboutUser = req.getParameterMap().get(headerAboutUser);

        if (aboutUser != null) {
            writer.write("<p>Вы написало о себе следующее: " + aboutUser[0] + "</p>");
        }


        Poll poll = new Poll(Integer.parseInt(poolsPerformer[0]), new int[]{Integer.parseInt(poolsGenres[0]), Integer.parseInt(poolsGenres[1]), Integer.parseInt(poolsGenres[2])}, aboutUser[0]);
        pollService.creatPoll(poll);
        writer.write("<p>" + pollService.getPolls().get(pollService.getPolls().size() - 1) + "</p>");

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            FileWriter writer = new FileWriter("pools.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(pollService.getPolls().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            FileWriter writer = new FileWriter("pools.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(pollService.getPolls().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
