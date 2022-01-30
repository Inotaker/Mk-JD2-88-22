package by.it.academy.Mk_JD2_88_22.endpoints;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
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


    private static String NAME_PARAMETER_HEADER = "PERFORMER_POOL";
    private static String NAME_PARAMETER_HEADER_SECOND = "GENRE_POOL";
    private static String NAME_PARAMETER_HEADER_THIRD = "ABOUT_ME";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IPoolService service = PoolService.getInstance();
        List<String> artists = service.getArtists();
        List<String> genres = service.getGenres();


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


        Pool pool = new Pool(Integer.parseInt(poolsPerformer[0]), new int[]{Integer.parseInt(poolsGenres[0]), Integer.parseInt(poolsGenres[1]), Integer.parseInt(poolsGenres[2])}, aboutUser[0]);
        service.creatPool(pool);
        writer.write("<p>" + service.getPools().get(service.getPools().size()-1) + "</p>");

    }
}
