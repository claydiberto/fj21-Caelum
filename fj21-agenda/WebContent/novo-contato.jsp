<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="agenda" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Novo contato</title>
		<link rel="stylesheet" href="css/jquery-ui.css">
		<script src="js/jquery.js"></script>
  		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<h1>Novo Contato</h1>
		<hr />
		<form action="adicionaContato" method="POST">
			Nome: <input type="text" name="nome" size="50" /><br />
			E-mail: <input type="text" name="email" size="50" /><br />
			Telefone: <input type="text" name="telefone" size="30" /><br />
			Data de Nascimento: <agenda:campoData id="dataNascimento" /><br />
			<input type="submit" value="Criar" />
		</form>
	</body>
</html>