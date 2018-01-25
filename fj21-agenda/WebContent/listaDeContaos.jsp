

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.model.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contatos</title>
    </head>
    <body>
        <h1>Lista de contatos</h1>
        <hr />
        <table>
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Data de Nascimento</th>
            </tr>
            <%
                ContatoDao dao = new ContatoDao();
                List<Contato> contatos = dao.listar();
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for (Contato contato : contatos) {
            %>      
                <tr>
                    <td><%=contato.getNome() %></td>
                    <td><%=contato.getEmail() %></td>
                    <td><%=contato.getTelefone() %></td>
                    <td><%=sdf.format(contato.getDataNascimento().getTime()) %></td>
                </tr>
                <%
                }
                %>
        </table>
    </body>
</html>