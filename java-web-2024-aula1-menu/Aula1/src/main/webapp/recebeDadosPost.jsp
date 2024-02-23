<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Pessoa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
      Pessoa pessoa = new Pessoa();
      pessoa.setNome(request.getParameter("nome"));
      pessoa.setIdade(Integer.parseInt(request.getParameter("idade")));
  %>
  <p><% out.write(pessoa.verificarIdade()); %></p>
</body>
</html>