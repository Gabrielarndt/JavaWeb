<%@page import="utils.Conexao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Aula2 - POO </h1>
    <nav>
        <%@include file="./menu.jsp"%>
    </nav>
    <%
        out.write(Conexao.conectar());
    %> 
</body>
</html>