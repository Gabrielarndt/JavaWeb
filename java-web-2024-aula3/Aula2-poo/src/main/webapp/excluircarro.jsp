<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.DaoCarro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir carro</title>
</head>
<body>
    <%
       String idCarro = request.getParameter("id");
       DaoCarro.excluir(Integer.parseInt(idCarro));
       response.sendRedirect("./consulta.jsp");
    %>
</body>
</html>