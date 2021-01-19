<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JavaBeans"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Foto</h1>
	<a href="foto.jsp" class="Botao1">Novo foto</a>
		<table id="estilo">
		<thead>
			
			<th>Id-Foto</th>
			<th>Foto1</th>
			<th>Foto2</th>
			<th>Foto3</th>
			<th>Foto4</th>
			<th>Ações</th>
			
			
		</thead>		
		
			<tbody>
		<%
		//objeto dao criado para acessar os métodos da classe DAO
		DAO daoidfot = new DAO();
		ArrayList<JavaBeans> foto = daoidfot.listarFoto(); //1 e 5
		for (int i =0 ; i <foto.size(); i++) { 
		%>
	
			<tr>
			
			<td><%=foto.get(i).getIdfoto()%></td>
			<td><%=foto.get(i).getFoto1()%></td>
			<td><%=foto.get(i).getFoto2()%></td>
			<td><%=foto.get(i).getFoto3()%></td>
			<td><%=foto.get(i).getFoto4()%></td>
			
			
			<!-- select -> requisição ao controller -->	
			<td><br><a href="update3?idfoto=<%=foto.get(i).getIdfoto()%>"class="Botao1">Editar.F</a>
			<a href="update4?idproduto="class="Botao1">Excluir</a></td>
			
		</tr>
		<%
		}
		%>
	</table>
	

	

</body>
</html>