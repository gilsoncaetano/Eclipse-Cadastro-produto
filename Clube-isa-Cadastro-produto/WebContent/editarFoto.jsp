<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    String idfoto = (String) request.getAttribute("idfoto");
    String foto1 = (String) request.getAttribute("foto1");
    String foto2 = (String) request.getAttribute("foto2");
    String foto3 = (String) request.getAttribute("foto3");
    String foto4 = (String) request.getAttribute("foto4");
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
	
	
	<form name="frmFoto" action="update4">
	
	
		<h2>Cadastro de Foto</h2>
    	<table> 
    		<tr>
    			<td><input type="text" name="idfoto"value="<%=idfoto%>"class="Caixa1" readonly ></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto1"value="<%=foto1 %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto2"value="<%=foto2 %>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto3"value="<%=foto3%>"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto4"value="<%=foto4%>"class="Caixa1"></td>
    		</tr>
    	</table>
    	      	
    	<input type="button" value="Cadastrar" onclick="validar()"class="Botao2">        	
    </form>
		
	<script src="validarfoto.js" ></script>
</body>
</html>