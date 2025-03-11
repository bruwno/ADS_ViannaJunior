
<%@ page import="br.vianna.aula.Servlet.model.Pessoa" %>
<html>
<body>

<div class="container">
    <h1 class="header">IMC Web App</h1>
    <div class="body">
        <div class="form">
        <%
        String nome = request.getParameter("cpNome");
        double imc = (double)request.getAttribute("imc");

        Pessoa pes =  (Pessoa)request.getAttribute("pessoa");
        %>
            <h1>
                Olá <% out.print(pes.getNome()); %>, <br />
                seu imc é de <% out.print( pes.imc() ); %>
            </h1>
        </div>
    </div>
</div>

</body>
</html>
