<%@page import="dao.DaoContato"%>
<%@page import="entidades.Contato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Consulta contato</h1>
   <%
     List<Contato> lista = DaoContato.consultar();  
   
   %>
   
	<nav>
		<%@include file="./menu.jsp"%>
	</nav>
	<main>
   <table>
      <thead>
         <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Fone</th>
         </tr>
      </thead>
      <tBody>
         <%
          for(Contato ct : lista){
        	 out.write("<tr>"); 
          	 out.write("<td>"+ ct.getNome() + "</td>");
          	 out.write("<td>"+ ct.getEmail()+ "</td>");
          	 out.write("<td>"+ ct.getFone() + "</td>");
          	 out.write("</tr>");
           }
         %>
      </tBody>
   </table>
  </main>
</body>
</html>