package by.it.academy.Mk_JD2_88_22.endpoints;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;
import by.it.academy.Mk_JD2_88_22.service.api.dto.Pool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PoolServlet", urlPatterns = "/pool")
public class PoolServlet extends HttpServlet {


    private static String NAME_PARAMETER_HEADER = "PPP";
    private static String NAME_PARAMETER_HEADER_SECOND = "PGM";
    private static String NAME_PARAMETER_HEADER_THIRD = "AMP";


    private int choosenArtists;
    private int[] choosenGenres = new int[3];
    private String aboutUserString;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IPoolService service = new PoolService();
        List<String> artists = service.getArtists();
        List<String> genres = service.getGenres();


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        String headerPoolPerformer = req.getHeader(NAME_PARAMETER_HEADER);
        String[] poolsPerformer = req.getParameterMap().get(headerPoolPerformer);

        if (poolsPerformer != null) {
            for (String pool : poolsPerformer) {
                if (Integer.parseInt(pool) == 1) {
                    writer.write("<br>");
                    writer.write("<p> Ваш голос был отдан за " + artists.get(0) + "</p>");
                    choosenArtists = 1;
                }
                if (Integer.parseInt(pool) == 2) {
                    writer.write("<br>");
                    writer.write("<p> Ваш голос был отдан за " + artists.get(1) + "</p>");
                    choosenArtists = 2;
                }
                if (Integer.parseInt(pool) == 3) {
                    writer.write("<br>");
                    writer.write("<p> Ваш голос был отдан за " + artists.get(2) + "</p>");
                    choosenArtists = 3;
                }
                if (Integer.parseInt(pool) == 4) {
                    writer.write("<br>");
                    writer.write("<p> Ваш голос был отдан за " + artists.get(3) + "</p>");
                    choosenArtists = 4;
                }
            }
        }


        String headerPoolGenres = req.getHeader(NAME_PARAMETER_HEADER_SECOND);
        String[] poolsGenres = req.getParameterMap().get(headerPoolGenres);

        if (poolsGenres.length == 3) {
            writer.write("<p>Вы отдали голос за жанры : ");
            for (int i = 0; i < poolsGenres.length; i++) {
                int a = Integer.parseInt(poolsGenres[i]);
                writer.write(a + "." + genres.get(a-1)+ ", ");
                choosenGenres[i] = a;
            }
            writer.write("</p><br>");
        }


        String headerAboutUser = req.getHeader(NAME_PARAMETER_HEADER_THIRD);
        String[] aboutUser = req.getParameterMap().get(headerAboutUser);

        if (aboutUser != null) {
            for (String s : aboutUser) {
                writer.write("<p>Вы написало о себе следующее: " + s + "</p>");
                aboutUserString = s;
            }
        }


        Pool pool = new Pool(choosenArtists, choosenGenres, aboutUserString);
        service.creatPool(pool);
        writer.write("<p>" + service.getPools().toString() + "</p>");

    }
}
