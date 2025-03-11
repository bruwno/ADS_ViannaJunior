package br.vianna.aula.Servlet;

import br.vianna.aula.Servlet.model.Pessoa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/terceiro")
public class TerceiroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa p = new Pessoa(req.getParameter("cpNome"),
                Double.parseDouble( req.getParameter("cpPeso")),
                Double.parseDouble( req.getParameter("cpAltura"))
        );

        //usar ?????
        String page = "resultado2.jsp";

        req.setAttribute("nm",p.getNome());
        req.setAttribute("imc",p.imc());

        req.setAttribute("pessoa",p);

        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req,resp);
    }

}
