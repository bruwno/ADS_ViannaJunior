package br.vianna.aula.Servlet;

import br.vianna.aula.Servlet.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/primeiro")
public class PrimeiroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        doRequest(req, resp);
    }

    private static void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        double peso = Double.parseDouble( req.getParameter("cpPeso") );
//        double altura = Double.parseDouble( req.getParameter("cpAltura") );
//        double imc = peso/(altura*altura);
        Pessoa p = new Pessoa(req.getParameter("cpNome"),
                Double.parseDouble( req.getParameter("cpPeso")),
                Double.parseDouble( req.getParameter("cpAltura"))
        );

        //Primeira forma de resposta, cria uma página do Zero
        String page = "<html>\n" +
                "<body>\n" +
                "    <h1>Olá "+p.getNome()+"</h1>\n" +
                "    <h2>IMC : "+p.imc()+" </h2>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        resp.getWriter().println(page);
    }
}
