<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
  <div class="container">
		<h1 class="text-center mt-5">Aula2 - POO</h1>
		<nav class="mt-5">
			<%@include file="./menu.jsp"%>
		</nav>
		<main class="mt-5">
		    <h2>Já existe um carro com essa placa: <span style="color:red"> <%= request.getParameter("placa") %></span></h2>
		    <h3><%= session.getAttribute("modelo") %></h3>
		</main>
	</div>
    
</body>
</html>