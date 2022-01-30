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

@WebServlet(name = "GetArtistListServlet", urlPatterns = ("/artists_list"))
public class GetArtistListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        IPoolService service = new PoolService();
        List<String> artists = service.getArtists();


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        writer.write("<p>Выберите любимого исполнителя,написав соответсвующий голос в хэдер\"PERFORMER_POOL\"</p>");
        for (int i = 0; i < artists.size(); i++) {
            writer.write("<p>" + (i + 1) + "." + artists.get(i) + "</p>");
        }
        writer.write("<p>Напишите допольнительную информацию о себе в хэдер \"GENRE_POOL\"</p><br>");
    }
}
