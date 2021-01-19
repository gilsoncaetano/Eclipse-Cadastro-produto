/**
 * Validação de Formulàrio
 * @author Gilson Caetano 
 */

function validar(){
	
	let tipo = frmProduto.tipo.value
	let nomeproduto = frmProduto.nomeproduto.value
	let descricao = frmProduto.descricao.value
	let preco = frmProduto.preco.value
		
	if (tipo == ""){
		alert('Tipo do Produto')
		frmProduto.tipo.focus()
		return false
	}else if(nomeproduto == ""){
		alert('Preencha o campo Nome Produto')
		frmProduto.nomeproduto.focus()
		return false
	}else if(descricao ==""){
		alert('Peencha o campo Descrição do Produto')
		frmProduto.descricao.focus()
		return false
	}else if(preco == ""){
		alert('Preencha o campo Preço do Produto')
		frmProduto.preco.focus()
		return false
		
	}else {
		document.forms["frmProduto"].submit()
	}
	
}