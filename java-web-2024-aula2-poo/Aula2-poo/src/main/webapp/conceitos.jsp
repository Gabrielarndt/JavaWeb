<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
       Carro c1 = new Carro();
       c1.modelo = "fusca";
       c1.placa = "abc-1234";
       out.write("<p>Modelo: " + c1.modelo + " placa: " + c1.placa );
       
       Carro c2 = new Carro();
       c2.modelo = "Kombi";
       c2.placa = "def-5678";
       out.write("<p>Modelo: " + c2.modelo + " placa: " + c2.placa );
       
       Carro c3;//declara o objeto
       c3 = new Carro(); //construindo uma instancia do objeto
       
       try{
	       Produto p1 = new Produto();
	       //p1.preco = -10.0;
	       p1.setPreco(10.0);
	       out.write("<p>"+ p1.getPreco() +"</p>");
	       
	       //sobrecarga de construtor
	       Produto p2 = new Produto("Milho",-20.0);
	       out.write("<p>"+ p2.getDescricao() + " " + p2.getPreco() +"</p>");
       }catch(RuntimeException ex){
    	  out.write("<br>Erro: " + ex.getMessage()); 
       }
    %>
</body>
</html>