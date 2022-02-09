package by.it.academy.Mk_JD2_88_22.controllers.web.servlets.person;

import by.it.academy.Mk_JD2_88_22.service.dto.person.Person;
import by.it.academy.Mk_JD2_88_22.service.api.person.IStorageService;
import by.it.academy.Mk_JD2_88_22.service.person.SelectedFromHeaderStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    private static int countSession = 0;

    private IStorageService selectedStorage;

    public PersonServlet() {
        this.selectedStorage = new SelectedFromHeaderStorage();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String ageRaw = req.getParameter("age");

        if (firstName == null || lastName == null || ageRaw == null) {
            throw new IllegalArgumentException("Переданы не все данные");
        }

        int age = Integer.parseInt(ageRaw);

        Person p = new Person(firstName, lastName, age);

        selectedStorage.addToStorage(p, req, resp);

        Person personFromStorage = selectedStorage.getFromStorage(req, resp);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write(personFromStorage.toString());
    }
}
