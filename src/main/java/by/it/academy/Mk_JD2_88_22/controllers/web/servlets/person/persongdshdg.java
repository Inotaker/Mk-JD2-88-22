//package by.it.academy.Mk_JD2_88_22.endpoints.servlets.person;
//
//import by.it.academy.Mk_JD2_88_22.service.api.dto.person.Person;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "PersonServlet", urlPatterns = "/person")
//public class PersonServlet extends HttpServlet {
//
//    private static final String PARAMETER_FIRST_NAME = "firstName";
//    private static final String PARAMETER_LAST_NAME = "lastName";
//    private static final String PARAMETER_AGE = "age";
//    public static final String PARAMETER_TYPE_STORAGE = "typeStorage";
//
//    Person person = new Person();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//
//        String typeStorage = req.getParameter(PARAMETER_TYPE_STORAGE);
//        if (typeStorage != null) {
//            switch (Integer.parseInt(typeStorage)) {
//                case 1:
//                    setSessionType(req);
//                    break;
//                case 2:
//                    setCookieType(req, resp);
//                    break;
//                default:
//                    break;
//            }
//        } else {
//            throw new IllegalArgumentException("Не выбран тип хранилища typeStorage=(1 - сессия, 2 - куки)");
//        }
//        writer.write("</p>" + this.person + "</p>");
//    }
//
//    private void setCookieType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        String firstName = req.getParameter(PARAMETER_FIRST_NAME);
//        String lastName = req.getParameter(PARAMETER_LAST_NAME);
//        String age = req.getParameter(PARAMETER_AGE);
//
//        if (firstName == null) {
//            firstName = getCookiesValue(PARAMETER_FIRST_NAME, req);
//            this.person.setFirstName(firstName);
//            if (firstName == null) {
//                throw new IllegalArgumentException("Параметр имени отсутствует");
//            }
//        } else {
//            saveCookies(PARAMETER_FIRST_NAME, firstName, resp);
//            this.person.setFirstName(firstName);
//        }
//
//        if (lastName == null) {
//            lastName = getCookiesValue(PARAMETER_LAST_NAME, req);
//            this.person.setLastName(lastName);
//            if (lastName == null) {
//                throw new IllegalArgumentException("Параметр фамилии отсутствует");
//            }
//        } else {
//            saveCookies(PARAMETER_LAST_NAME, lastName, resp);
//            this.person.setLastName(lastName);
//        }
//
//        if (age == null) {
//            age = getCookiesValue(PARAMETER_AGE, req);
//            this.person.setAge(Integer.parseInt(age));
//            if (age == null) {
//                throw new IllegalArgumentException("Параметр возраста отсутствует");
//            }
//        } else {
//            saveCookies(PARAMETER_AGE, age, resp);
//            this.person.setAge(Integer.parseInt(age));
//        }
//    }
//
//    private void setSessionType(HttpServletRequest req) {
//        HttpSession session = req.getSession();
//
//        String firstName = req.getParameter(PARAMETER_FIRST_NAME);
//        String lastName = req.getParameter(PARAMETER_LAST_NAME);
//        String age = req.getParameter(PARAMETER_AGE);
//
//        if (firstName == null) {
//            firstName = (String) session.getAttribute(PARAMETER_FIRST_NAME);
//            if (firstName == null) {
//                throw new IllegalArgumentException("Не передан параметр имени");
//            }
//        } else {
//            session.setAttribute(PARAMETER_FIRST_NAME, firstName);
//        }
//
//        if (lastName == null) {
//            lastName = (String) session.getAttribute(PARAMETER_LAST_NAME);
//            if (lastName == null) {
//                throw new IllegalArgumentException("Не передан параметр фамилии");
//            }
//        } else {
//            session.setAttribute(PARAMETER_LAST_NAME, lastName);
//        }
//
//        if (age == null) {
//            age = (String) session.getAttribute(PARAMETER_AGE);
//            if (age == null) {
//                throw new IllegalArgumentException("Не передан параметр возраста");
//            }
//        } else {
//            session.setAttribute(PARAMETER_AGE, age);
//        }
//
//        this.person.setFirstName(firstName);
//        this.person.setLastName(lastName);
//        this.person.setAge(Integer.parseInt(age));
//        session.invalidate();
//    }
//
//    private String getCookiesValue(String cookiesName, HttpServletRequest req) {
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookiesName.equals(cookie.getName())) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
//
//    private void saveCookies(String cookiesName, String value, HttpServletResponse resp) {
//        Cookie cookie = new Cookie(cookiesName, value);
//        resp.addCookie(cookie);
//    }
//}
