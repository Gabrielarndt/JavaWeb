<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="classes.Carro" %>
<%@page import="dao.DaoCarro"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta Carros</title>
</head>
<body>
     <h1>Listar Carros</h1>
	<nav>
		<%@include file="./menu.jsp"%>
	</nav>
	<main>
	   <table>
	       <thead>
	          <tr>
	             <th>Placa</th>
	             <th>Modelo</th>
	           </tr>
	       </thead>
	       <tbody>
	          <%
	            /* for(int i = 0; i < DaoCarro.carros.size(); i++){
	            	Carro carro = DaoCarro.carros.get(i);
	            	out.write("<tr>"); 
	            	out.write("<td>"+ carro.getPlaca()+"</td>"); 
	            	out.write("<td>"+ carro.getModelo()+"</td>"); 
	            	out.write("</tr>"); 
	             }*/
	            List<Carro> carros = DaoCarro.consultar();
	            for(int i = 0; i < carros.size(); i++){
	            	Carro carro = carros.get(i);
	            	out.write("<tr>"); 
	            	out.write("<td>"+ carro.getPlaca()+"</td>"); 
	            	out.write("<td>"+ carro.getModelo()+"</td>"); 
	            	out.write("</tr>"); 
	             }
	          %>
	       </tbody>
	   </table>
	</main>
</body>
</html>