<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.JavaBeans"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Clube de Tiro </title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	
	<form name="frmFoto" action="insert1">
	
	
		<h2>Cadastro de Foto</h2>
		
	
    	<table> 
    	
    		<tr>
    		<td><input type="text" name="foto1" placeholder="Foto 1"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto2" placeholder="Foto 2"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto3" placeholder="Foto 3"class="Caixa1"></td>
    		</tr>
    		<tr>
    			<td><input type="text" name="foto4" placeholder="Foto 4"class="Caixa1"></td>
    		</tr>
    		
    		
    	</table>	
			
		<%
		//objeto dao criado para acessar os métodos da classe DAO
		DAO idfot = new DAO();
		ArrayList<JavaBeans> foto = idfot.listarIdfoto(); //1 e 5
		for (int i =0 ; i <foto.size(); i++) { 
		%>	
    		<input type= "button" value="Salvar" onclick="validar()"class="Botao2">     
    		<a href="update5?idfoto=<%=foto.get(i).getIdfoto()%>"class="Botao1">Próximo</a>
    		
		<%
		}
		%>
		      	
    	       	
    </form>
		
	<script src="validarfoto.js" ></script>
</body>
</html>