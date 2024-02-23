<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="classes.Carro"%>
<%@page import="dao.DaoCarro"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta Carros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">

		<h1 class="text-center mt-5">Listar Carros</h1>
		<nav class="mt-5">
			<%@include file="./menu.jsp"%>
		</nav>
		<main class="mt-5">
			<table class="table">
				<thead>
					<tr>
					    <th>Id</th>
						<th>Placa</th>
						<th>Modelo</th>
						<th>Ações</th>						
					</tr>
				</thead>
				<tbody>
					<%					
					List<Carro> carros = DaoCarro.consultar();
					for (int i = 0; i < carros.size(); i++) {
						Carro carro = carros.get(i);
						out.write("<tr>");
						out.write("<td>" + carro.getId() + "</td>");
						out.write("<td>" + carro.getPlaca() + "</td>");
						out.write("<td>" + carro.getModelo() + "</td>");
						out.write("<td><a href='./editarcarro.jsp?id="+carro.getId()+"'>Editar</a> &nbsp;&nbsp;");
						out.write("<a href='./excluircarro.jsp?id="+carro.getId()+"'>Excluir</a></td>");
						out.write("</tr>");
					}
					%>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>