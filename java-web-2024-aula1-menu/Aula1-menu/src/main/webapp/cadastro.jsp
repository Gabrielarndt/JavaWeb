<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
  <link rel="stylesheet" type="text/css" href="./estilos/styles.css" />
  <style>
     input{
        width: 100%
     }
  </style>
</head>
<body>
	<h1>Pagina de cadastro</h1>
	<nav>
		<%@include file="./menu.jsp"%>
	</nav>
	<main>
		<form method="get" action="recebeDadosContato.jsp">
			<label for="nome">Informe seu nome</label> 
			<input type="text"placeholder="Informe nome" id="nome" name="nome" /> 
			
			<label for="email">Informe seu email</label> 
			<input type="email"	placeholder="Informe email" id="email" name="email" />
			
			<label for="fone">Informe seu fone</label> 
			<input type="text"	placeholder="Informe fone" id="fone" name="fone" />

			<button>Enviar</button>
		</form>
	</main>
	<footer> Direitos Autorais</footer>
</body>
</html>