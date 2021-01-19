/**
 * Validação de Formulàrio
 * @author Gilson Caetano 
 */

function validar(){
	
	let foto1 = frmFoto.foto1.value
	let foto2 = frmFoto.foto2.value
	let foto3 = frmFoto.foto3.value
	let foto4 = frmFoto.foto4.value
	
		
	if (foto1 == ""){
		alert('Preencha o campo Foto 1')
		frmFoto.foto1.focus()
		return false
	}else if(foto2 == ""){
		alert('Preencha o campo Foto 2')
		frmFoto.foto2.focus()
		return false
	}else if(foto3 ==""){
		alert('Peencha o campo Foto 3')
		frmFoto.foto3.focus()
		return false
	}else if(foto4 == ""){
		alert('Preencha o campo Foto 4')
		frmFoto.foto4.focus()
		return false
		
	}else {
		document.forms["frmFoto"].submit()
	}
	
}