<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String nome;
	nome = "Carlos Caramujo";
	out.write(nome);

	int idade = 18;
	String msg = "maior";
	if (idade < 18)
		msg = "menor";
	/* out.write("<p>Você é " + msg + " de idade.<p>");*/
	%>
	<p><% out.write("Você é " + msg + " de idade"); %></p>
</body>
</html>