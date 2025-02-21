package br.vianna.aula.servlet;

import br.vianna.aula.servlet.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/segundo")
public class SegundoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private static void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("cpNome");
        double peso = Double.parseDouble(req.getParameter("cpPeso"));
        double altura = Double.parseDouble(req.getParameter("cpAltura"));

        Pessoa p = new Pessoa(nome, peso, altura);

        String page = "";

        resp.getWriter().println(page);
    }
}
