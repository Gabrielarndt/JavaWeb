<%@page import="dao.DaoCarro"%>
<%@ page import="classes.Carro" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Cadastro de Carro</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
	   rel="stylesheet" 
	   integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
	   crossorigin="anonymous">
</head>
<body>
    <%
       String idCarro = request.getParameter("id");
       Carro carro = DaoCarro.consultarPorId(Integer.parseInt(idCarro));
    %>
	<div class="container mt-3">
		<h1 class="text-center mt-5">Editar Carro</h1>
		<nav class="mt-5 mb-3">
			<%@include file="./menu.jsp"%>
		</nav>
		<main class="mt-5">
			<form action="gravarcarro.jsp" method="post">
			    <label class="form-label">ID do carro</label> 
				<input class="form-control" type="text" value='<%= idCarro %>' name="id" /> 
				
				<label class="form-label">Informe placa do carro</label> 
				<input class="form-control" type="text" value='<%= carro.getPlaca() %>' placeholder="Informe placa do carro" name="placa" /> 
				
				<label class="form-label">Informe modelo do carro</label> 
				<input class="form-control" type="text" value='<%= carro.getModelo() %>' placeholder="Informe modelo do carro" name="modelo" />

				<button class="btn btn-outline-primary mt-3">Gravar</button>

			</form>
		</main>

	</div>
</body>
</html>