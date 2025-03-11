<html>
<body>

<div class="container">
    <h1 class="header">IMC Web App</h1>
    <div class="body">
        <div class="form">
            <h1>
            <%
                String nome = request.getParameter("nm");
                Double imc = Double.parseDouble(request.getParameter("imc"));
            %>
                Olá <% out.print(nome); %>, <br />
                seu imc é de <% out.print(imc); %>
               <%
                    if (imc >=50){
                %>
                <br />Cuidado, está acima do Peso
                <%
                    }
                %>

                <%
                    if (imc >=50){
                out.print( "<br />Cuidado, está acima do Peso" );
                    }
                %>

            </h1>
        </div>
    </div>
</div>

</body>
</html>
