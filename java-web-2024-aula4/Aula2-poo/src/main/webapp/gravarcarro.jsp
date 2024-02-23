<%@page import="dao.DaoCarro"%>
<%@ page import="classes.Carro"%>
<%@page import="java.util.List"%>
<%
String id = request.getParameter("id");
String placa = request.getParameter("placa");
String modelo = request.getParameter("modelo");

if (id != null) {
	Carro carro = new Carro(Integer.parseInt(id), placa, modelo);
	if (DaoCarro.alterar(carro)) {
      response.sendRedirect("./consulta.jsp");
	}
}
else{
	List<Carro> carros = DaoCarro.consultar();
	boolean placaExiste = false;
	for (Carro c : carros) {
		if (c.getPlaca().equals(placa)) {
			placaExiste = true;
			break;
		}
	}
	
	if (placaExiste) {
		session.setAttribute("modelo",modelo);
		response.sendRedirect("./info.jsp?placa="+placa);
	}
	else{
		Carro carro = new Carro(placa, modelo);
		if (DaoCarro.salvar(carro)) {
	       response.sendRedirect("./consulta.jsp");
		}
	}
}
	


 
%>