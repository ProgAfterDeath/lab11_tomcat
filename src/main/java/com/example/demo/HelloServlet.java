package com.example.demo;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private Arithmetic arithmetic;

    @Override
    public void init() throws ServletException {
        super.init();
        arithmetic = new Arithmetic();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        arithmetic.setStart(Integer.parseInt(request.getParameter("start")));
        arithmetic.setEnd(Integer.parseInt(request.getParameter("end")));
        arithmetic.setStep(Double.parseDouble(request.getParameter("step")));
        arithmetic.setValue(Double.parseDouble(request.getParameter("value")));

        arithmetic.fillingListOfPoints(arithmetic.getStart(), arithmetic.getEnd(),
                arithmetic.getStep(), arithmetic.getValue());

        pr.println("<html>");
        pr.println("<h2>Результати <a href=\"/demo_war_exploded\">Занести нові результати<a/></h2>");
        pr.println("<dt>Мінімальне значення функції</dt>");
        pr.println("<dt>x = " + arithmetic.getMinPoint().getX() + "</dt>");
        pr.println("<dt>y = " + arithmetic.getMinPoint().getY() + "</dt>");
        pr.println("<dt>індекс = " + arithmetic.findMinIndex() + "</dt><br/>");
        pr.println("<dt>Максимальне значення функції<dt/>");
        pr.println("<dt>x = " + arithmetic.getMaxPoint().getX() + "</dt>");
        pr.println("<dt>y = " + arithmetic.getMaxPoint().getY() + "</dt>");
        pr.println("<dt>індекс = " + arithmetic.findMaxIndex() + "</dt><br/>");
        pr.println("<dt>Сумма значень елементів: " + arithmetic.summPoints() + "<dt/>");
        pr.println("<dt>Середнє значення елементів: " + arithmetic.averageOfPoints() + "<dt/><br/>");
        pr.println("<table border=\"1\">");
        pr.println("<tbody>");
        pr.println("<tr>");
        pr.println("<td>X</td>");
        pr.println("<td>Y</td>");
        pr.println("</tr>");
        for (Point point : arithmetic.getPoints()) {
            pr.println("<tr>");
            pr.println("<td>" + point.getX() + "</td>");
            pr.println("<td>" + point.getY() + "</td>");
            pr.println("</tr>");
        }
        pr.println("</tbody>");
        pr.println("</table>");
        pr.println("</html>");

    }

    public void destroy() {
    }
}