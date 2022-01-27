package by.it.academy.Mk_JD2_88_22.endpoints;

import by.it.academy.Mk_JD2_88_22.service.PoolService;
import by.it.academy.Mk_JD2_88_22.service.api.ChoiceWithCount;
import by.it.academy.Mk_JD2_88_22.service.api.IPoolService;
import by.it.academy.Mk_JD2_88_22.service.api.dto.SavedPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(name = "PoolResultServlet", urlPatterns = "/pool_result")
public class PoolResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        IPoolService poolService = new PoolService();
        for (SavedPool pool : ChoiceWithCount.getPoolsModified()) {
            writer.write("</p>" + pool.toString() + "</p>");
            writer.write("<p></p>");
        }
        writer.write("<p>" + ChoiceWithCount.getPerformerTop() + "</p>");
        writer.write("<p></p>");
        writer.write("<p>" + ChoiceWithCount.getGenresTop() + "</p>");
        writer.write("<p></p>");
        for (int i = 0; i < poolService.getPools().size(); i++) {
            writer.write(poolService.getPools().get(i).getTime().toString());
        }
        Collections.sort(ChoiceWithCount.getPoolsModified().);
    }


}
