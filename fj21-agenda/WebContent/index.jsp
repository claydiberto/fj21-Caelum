<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Agenda</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<div>
        	<a href="novo-contato.jsp">
        		<input type="button" value="Novo" />
       		</a>
        </div><br />
        <jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"/>
        <table border="1">
            <tr bgcolor="#a9a9a9">
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Data de Nascimento</th>
            </tr>
            <c:forEach var="contato" items="${dao.listar()}" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? 'c0c0c0':'ffffff'}"	>
                    <td>${id.count}</td>
                    <td>${contato.nome}</td>
                    <td>
                        <c:choose>
                        	<c:when test="${not empty contato.email}">
                        		<a href="mailto:${contato.email}">${contato.email}</a>
                        	</c:when>
                        	<c:otherwise>
                        		E-mail não informado
                        	</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${contato.telefone}</td>
                    <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="rodape.html" />
    </body>
</html>
