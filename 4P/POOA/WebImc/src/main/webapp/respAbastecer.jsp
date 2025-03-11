<%@ page import="br.vianna.aula.Servlet.model.Abastecer" %>
<html>
<body>

<div class="container">
    <h1 class="header">App Abastecimento</h1>
    <div class="body">
        <div class="form">
        <%
            Abastecer ab = (Abastecer) request.getAttribute("abastecimento");
        %>
            <h1>
             <%
                if (ab.abastecerComGasolina()) {
             %>
                Olá, abasteça com abasteça com gasolina
              <%
              } else {
                out.print("Olá, abasteça com Etanol");
              }
              %>
            </h1>
        </div>
    </div>
</div>

</body>
</html>
