package br.vianna.aula.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/primeiro" )
public class PrimeiroServlet extends HttpServlet {
    /* req  = recebe os dados do cliente
     * resp = devoolve a página com os dados da requisição
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        String page = "<html>\n" +
                "    <body>\n" +
                "        <h1>IMC Web App</h1>\n" +
                "    </body>\n" +
                "</html>";

        resp.getWriter().println(page);
    }
}
