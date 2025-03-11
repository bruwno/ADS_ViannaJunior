package br.vianna.aula.Servlet;


import br.vianna.aula.Servlet.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "segundo")
public class SegundoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                
        Pessoa p = new Pessoa(req.getParameter("cpNome"),
                Double.parseDouble( req.getParameter("cpPeso")),
                Double.parseDouble( req.getParameter("cpAltura"))
        );

        //usar o redirect
        String page = "resultado.jsp?nm="+p.getNome()+"&imc="+p.imc();

        try {
            resp.sendRedirect(page);
        } catch (IOException e) {
            resp.getWriter().println("<h1>Erro no redirect</h1>");
        }

    }
}
