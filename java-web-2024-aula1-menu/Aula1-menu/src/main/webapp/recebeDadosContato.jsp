<%@page import="dao.DaoContato"%>
<%@ page import="entidades.Contato" %>
<%
  String nome = request.getParameter("nome");
  String email = request.getParameter("email");
  String fone = request.getParameter("fone");
  
  Contato ct = new Contato();
  ct.setNome(nome);
  ct.setEmail(email);
  ct.setFone(fone);
  
  DaoContato.salvar(ct); 
  
  response.sendRedirect("./consulta.jsp");
%>