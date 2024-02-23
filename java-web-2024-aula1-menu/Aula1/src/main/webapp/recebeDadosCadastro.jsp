<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Insert title here</title>
   <style>
      p{
        background-color: red;
        color: blue;
      }
   </style>
</head>
<body>
	<%
	String nome = request.getParameter("nome");
	int idade = Integer.parseInt(request.getParameter("idade"));

	String msg = "maior";
	if (idade < 18)
		msg = "menor";
	%>
	<p>Ola, <% out.write(nome); %></p>
	<p>Você é <% out.write(msg); %> de idade</p>
	
</body>
</html>