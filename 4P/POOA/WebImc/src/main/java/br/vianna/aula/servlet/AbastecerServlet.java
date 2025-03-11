package br.vianna.aula.Servlet;

import br.vianna.aula.Servlet.model.Abastecer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/abastecer")
public class AbastecerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Abastecer ab = new Abastecer(
                Double.parseDouble(req.getParameter("cpGas")),
                Double.parseDouble(req.getParameter("cpAlc"))
        );

        String page = "respAbastecer.jsp";

        req.setAttribute("abastecimento", ab);

        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req,resp);
    }
}
