<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Carro</title>
</head>
<body>
	<div>
		<h1>Novo Carro</h1>
		<nav>
			<%@include file="./menu.jsp"%>
		</nav>
		<main>
			<form action="gravarcarro.jsp" method="post">
				<label>Informe placa do carro</label> 
				<input type="text" placeholder="Informe placa do carro" name="placa" /> 
				
				<label>Informe modelo do carro</label> 
				<input type="text"	placeholder="Informe modelo do carro" name="modelo" />

				<button>Gravar</button>

			</form>
		</main>

	</div>
</body>
</html>