<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%
 	// recebimento do conteudo JavaBeans encaminhado pelo Controller
 	String idproduto = (String) request.getAttribute("idproduto");
 	String tipo = (String) request.getAttribute("tipo");
 	String nomeproduto = (String) request.getAttribute("nomeproduto");
 	String descricao = (String) request.getAttribute("descricao");
 	String preco = (String) request.getAttribute("preco");
 	
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Clube de Tiro </title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<form name="frmProduto" action="update2">
		
		<h2>Editar Produto</h2>
		
    	<table> 
    	
    		<tr>
    			<td><input type="text" name="idproduto"value="<%=idproduto %>"class="Caixa1"  readonly ></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="tipo" value="<%=tipo %>" class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="nomeproduto"value="<%=nomeproduto %>" class="Caixa1"></td>
    		</tr>
    		<tr>
    		<td><textarea rows="4" cols="10" name="descricao" form="frmProduto" class="Caixadesc"><%=descricao %></textarea></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="preco"value="<%=preco %>"class="Caixa1"></td>
    		</tr>
    		    		
    	</table>
    	      	
    	<input type="button" value="Salvar" onclick="validar()"class="Botao2">        	
    </form>
		
	<script src="validador.js" ></script>
</body>
</html>