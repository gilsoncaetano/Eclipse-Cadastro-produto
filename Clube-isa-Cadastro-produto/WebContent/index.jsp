<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JavaBeans"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista de Produto</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Listagem de Cadastro de produtos</h1>
	<a href="foto.jsp"  class="Botao1" >Cadastar Produto</a>
	<table id="estilo">
		<thead>
			<th>Id</th>
			<th>Tipo</th>
			<th>Nome Produto</th>
			<th>Descrição</th>
			<th>Preço</th>
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
		DAO dao = new DAO();
		ArrayList<JavaBeans> produto = dao.listarProduto(); //1 e 5
		for (int i =0 ; i <produto.size(); i++) { 
		%>
		<tr>
			<td><%=produto.get(i).getIdproduto()%></td>
			<td><%=produto.get(i).getTipo()%></td>
			<td><%=produto.get(i).getNomeproduto()%></td>
			<td><%=produto.get(i).getDescricao()%></td>
			<td><%=produto.get(i).getPreco()%></td>
			<td><%=produto.get(i).getIdfoto()%></td>
			<td><%=produto.get(i).getFoto1()%></td>
			<td><%=produto.get(i).getFoto2()%></td>
			<td><%=produto.get(i).getFoto3()%></td>
			<td><%=produto.get(i).getFoto4()%></td>
			
			<td class="Caixab"><a href="update1?idproduto=<%=produto.get(i).getIdproduto()%>"class="Botao1">Editar.P</a>
			<br><br><a href="update3?idfoto=<%=produto.get(i).getIdfoto()%>"class="Botao1">Editar.F</a>
			<br><br><a href="update4?idproduto="class="Botao3">Excluir</a></td>
		</tr>
		
		
		<%
		}
		%>
		</tbody>
	</table>
	

	

</body>
</html>