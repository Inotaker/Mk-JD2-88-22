package by.it.academy.Mk_JD2_88_22.endpoints;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetGenresServlet", urlPatterns = "/genres_list")
public class GetGenresListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IPoolService service = PoolService.getInstance();
        List<String> genres = service.getGenres();


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        writer.write("<p>Выберите 3 любимых жанра,написав соответсвующие голоса в хэдер \"GENRE_POOL\"</p><br>");
        for (int i = 0; i < genres.size(); i++) {
            writer.write("<p>" + (i + 1) + "." + genres.get(i) + "</p>");
        }
        writer.write("<p>Напишите допольнительную информацию о себе в хэдер \"GENRE_POOL\"</p><br>");
    }
}
