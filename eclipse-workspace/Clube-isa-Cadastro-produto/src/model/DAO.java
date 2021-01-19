package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/*** Conex�o com banco de dados ***/
	// Par�metros de conex�o
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dbisaclube?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "";

	// M�todo de conex�o
		//Passo "5" ***/
		private Connection conectar() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			return con;
		}
		
		/*** CRUD ***/
		/* CRUD - Create Cadastro de produto e foto */
		public void novoProduto(JavaBeans produtos) {
			// Criar a query (comando sql)
			String create = "insert into produto(tipo, nomeproduto, descricao, preco, idfoto) values (?,?,?,?,?)";
			
			try {
				
				//Abrir conex�o com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
				pst.setString(1, produtos.getTipo());
				pst.setString(2, produtos.getNomeproduto());
				pst.setString(3, produtos.getDescricao());
				pst.setString(4, produtos.getPreco());
				pst.setString(5, produtos.getIdfoto());
				
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conex�o com banco de dados
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/* CRUD - Create foto*/
		public void novoFoto(JavaBeans fotos) {
			// Criar a query (comando sql)
			String create = "insert into foto(foto1,foto2,foto3,foto4) values (?,?,?,?)";
			
			try {
				//Abrir conex�o com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
								
				pst.setString(1, fotos.getFoto1());
				pst.setString(2, fotos.getFoto2());
				pst.setString(3, fotos.getFoto3());
				pst.setString(4, fotos.getFoto4());
				
												
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conex�o com banco de dados
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		
		
		/*  CRUD - Read Produto*/
		// m�todo com retorno usando oArryList ligado ao JavaBeans
		public ArrayList<JavaBeans> listarProduto(){
			// criar um vetor dinamico para receber as variaveis, que ser�o armazenada em JavaBeans 
			 ArrayList<JavaBeans> produto = new ArrayList<>();
			//query
			String read = "select p.idproduto, p.tipo, p.nomeproduto, p.descricao, p.preco,p.idfoto, f.foto1, f.foto2,f.foto3,f.foto4  \r\n" + 
					"       from produto p inner join foto f on p.idfoto=f.idfoto where idproduto=idproduto";
			try {
				//abrir a conex�o
				Connection con = conectar();
				// Prepara a query
				 PreparedStatement pst = con.prepareStatement(read);
				 //Executar a query
				 ResultSet rs = pst.executeQuery(); // (2)
				 // La�o de repeti��o que sera executado enquanto houver clientes
				 while (rs.next()){
				
					 // criar variaveis locais para receber os conteudos // (3)
					 String idproduto = rs.getString(1);
					 String tipo = rs.getString(2);
					 String nomeproduto = rs.getString(3);
					 String descricao = rs.getString(4);
					 String preco = rs.getString(5);
					 String idfoto = rs.getString(6);
					 String foto1 = rs.getString(7);
					 String foto2 = rs.getString(8);
					 String foto3 = rs.getString(9);
					 String foto4 = rs.getString(10);
					 // "popular" (preencher) o vetor // (4)
					 produto.add(new JavaBeans (idproduto,tipo,nomeproduto,descricao,preco,idfoto,foto1,foto2,foto3,foto4));
					
					 //fechar a conex�o
					//con.close();
				 }
				 return produto;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		/*  CRUD - Read Foto*/
		// m�todo com retorno usando oArryList ligado ao JavaBeans
		public ArrayList<JavaBeans> listarFoto(){
			// criar um vetor dinamico para receber as variaveis, que ser�o armazenada em JavaBeans 
			 ArrayList<JavaBeans> foto = new ArrayList<>();
			//query
			String read = "select p.idfoto, f.foto1, f.foto2,f.foto3,f.foto4,p.idproduto, p.nomeproduto, p.descricao, p.preco \r\n" + 
					"     from produto p inner join foto f on p.idfoto=f.idfoto where idproduto=idproduto";
			try {
				//abrir a conex�o
				Connection con = conectar();
				// Prepara a query
				 PreparedStatement pst = con.prepareStatement(read);
				 //Executar a query
				 ResultSet rs = pst.executeQuery(); // (2)
				 // La�o de repeti��o que sera executado enquanto houver Foto
				 while (rs.next()){
					 // criar variaveis locais para receber os conteudos // (3)
					 String idfoto = rs.getString(1);
					 String foto1 = rs.getString(2);
					 String foto2 = rs.getString(3);
					 String foto3 = rs.getString(4);
					 String foto4 = rs.getString(5);
					 				 
					 // "popular" (preencher) o vetor // (4)
					 foto.add(new JavaBeans (idfoto,foto1,foto2,foto3,foto4));
					
				 }
				 return foto;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		/* CRUD- Update */
		// Update 1 - M�todo para selecionar o Produto
		public void listarProduto(JavaBeans produtos) {
			// query
			String update1 = "select * from produto where idproduto=?";
			try {
				// abrir a conex�o
				Connection con = conectar();
				// Preparar a query
				PreparedStatement pst = con.prepareStatement(update1);
				// Substituir  o par�metro (?) pelo conte�do no objeto rs
				pst.setString(1, produtos.getIdproduto()); //(4)
				// Executa a query, armazenando o conte�do no objeto rs
				ResultSet rs = pst.executeQuery(); //(5)
				// La�o de repeti��o que ser� executatdo enquanto houver contatos
				while (rs.next()) {
					// teste de recebimento  // (6)
					//System.out.println(rs.getString(1));
					// Setar as vari�veis javaBeans com o select (banco de dados)passo (6)(7)
					produtos.setIdproduto(rs.getString(1));
					produtos.setTipo(rs.getString(2));
					produtos.setNomeproduto(rs.getString(3));
					produtos.setDescricao(rs.getString(4));
					produtos.setPreco(rs.getString(5));
					//con.close();
				}
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		// Update 2 - M�todo para Alterar o Produto
			public void alterarProduto(JavaBeans produtos) {
				// query
				String update2 = "update produto set tipo=?, nomeproduto=?, descricao=?,preco=? where idproduto=?";
				try {
				// abrir a conex�o
				Connection con = conectar();
				// Prepare a query
				PreparedStatement pst = con.prepareStatement(update2);
				// substituir os par�metros(?) pelo conte�do javaBeans (14)
				pst.setString(1, produtos.getTipo());
				pst.setString(2, produtos.getNomeproduto());
				pst.setString(3, produtos.getDescricao());
				pst.setString(4, produtos.getPreco());
				pst.setString(5, produtos.getIdproduto());
				// executa a query
				pst.executeUpdate(); //(15)
				//fechar a conex�o
				con.close();
							
				} catch (Exception e) {
				System.out.println(e);					
		}					
	}
			/* CRUD- Update */
			// Update 1 - M�todo para selecionar o Foto
			public void listarFoto(JavaBeans fotos) {
			// query
			String update3 = "select * from foto where idfoto=?";
			try {
			// abrir a conex�o
			Connection con = conectar();
				// Preparar a query
				PreparedStatement pst = con.prepareStatement(update3);
				// Substituir  o par�metro (?) pelo conte�do no objeto rs
				pst.setString(1, fotos.getIdfoto()); //(4)
				// Executa a query, armazenando o conte�do no objeto rs
				ResultSet rs = pst.executeQuery(); //(5)
				// La�o de repeti��o que ser� executatdo enquanto houver contatos
				while (rs.next()) {
				// teste de recebimento  // (6)
				//System.out.println(rs.getString(1));
				// Setar as vari�veis javaBeans com o select (banco de dados)passo (6)(7)
				fotos.setIdfoto(rs.getString(1));
				fotos.setFoto1(rs.getString(2));
				fotos.setFoto2(rs.getString(3));
				fotos.setFoto3(rs.getString(4));
				fotos.setFoto4(rs.getString(5));
				//con.close();
				}		
			} catch (Exception e) {
				System.out.println(e);
			}
		}

			
			
		// Update 2 - M�todo para Alterar o Foto
		public void alterarFoto(JavaBeans fotos) {
		// query
		String update4 = "update foto set foto1=?, foto2=?,foto3=?,foto4=? where idfoto=?";
		try {
		// abrir a conex�o
		Connection con = conectar();
		// Prepare a query
		PreparedStatement pst = con.prepareStatement(update4);
		// substituir os par�metros(?) pelo conte�do javaBeans (14)
		pst.setString(1,  fotos.getFoto1());
		pst.setString(2,  fotos.getFoto2());
		pst.setString(3,  fotos.getFoto3());
		pst.setString(4,  fotos.getFoto4());
		pst.setString(5,  fotos.getIdfoto());
		// executa a query
		pst.executeUpdate(); //(15)
		//fechar a conex�o
		con.close();
				
		} catch (Exception e) {
		System.out.println(e);					
			
		}					
	}
		
		// Update 1 - M�todo para selecionar o Foto
		public ArrayList<JavaBeans> listarIdfoto(){
			 ArrayList<JavaBeans> foto = new ArrayList<>();
		// query
		String read = "select * from foto order by idfoto desc limit 0,1";
		try {
		// abrir a conex�o
		Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(read);
			 //Executar a query
			 ResultSet rs = pst.executeQuery(); // (2)
			 while (rs.next()){
				 String idfoto = rs.getString(1);
				 foto.add(new JavaBeans (idfoto));
			 }
			 return foto;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
		
		/* CRUD  -  Delete */
		public void deletarProduto(JavaBeans produtos) {
			//query
			String delete = "delete from produto where idproduto=?";
			try {
				// abrir a conex�o 
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				// substiruir o par�metro ? pelo conte�do javaBeans
				pst.setString(1, produtos.getIdproduto()); // (4)
				// execute a query ("delelar o contato")
				pst.executeUpdate(); // (5)
				con.close();
			} catch (Exception e) {
				System.out.println(e);
		}
			
	}

}
