<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String idfoto = (String) request.getAttribute("idfoto");
    
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
	
	
	<form name="frmProduto" action="insert">
	
	
		<h2>Foto de Foto</h2>
    	<table> 
    		<tr>
    			<td><input type="text" name="idfoto"value="<%=idfoto%>"class="Caixa1" readonly ></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="tipo" placeholder="Produto Controlado Ou Permitido"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="nomeproduto" placeholder="Nome do Produto" class="Caixa1"></td>
    		</tr>
    		<tr>
    		<td><textarea rows="4" cols="10" name="descricao" placeholder="Descrição do Produto" form="frmProduto" class="Caixadesc"></textarea></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="preco" placeholder="Preço do Produto"class="Caixa1"></td>
    		</tr>
    		
    	</table>
    	      	
    	<input type="button" value="Cadastrar" onclick="validar()"class="Botao2">        	
    </form>
		
	<script src="validador.js" ></script>
</body>
</html>