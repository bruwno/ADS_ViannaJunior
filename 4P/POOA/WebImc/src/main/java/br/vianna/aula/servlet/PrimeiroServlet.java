package br.vianna.aula.servlet;

import br.vianna.aula.servlet.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/primeiro")
public class PrimeiroServlet extends HttpServlet {
    /* req  = recebe os dados do cliente
     * resp = devolve a página com os dados da requisição
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doRequest(req, resp);
    }

    private static void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("cpNome");
        double peso = Double.parseDouble(req.getParameter("cpPeso"));
        double altura = Double.parseDouble(req.getParameter("cpAltura"));

        Pessoa p = new Pessoa(nome, peso, altura);

        String page =
                "<html>\n" +
                        "    <body>\n" +
                        "        <h1>Olá " + p.getNome() + "</h1>\n" +
                        "        <p>Seu ICM é: " + p.getImc() + "</p>\n" +
                        "    </body>\n" +
                        "</html>";

        resp.getWriter().println(page);
    }
}