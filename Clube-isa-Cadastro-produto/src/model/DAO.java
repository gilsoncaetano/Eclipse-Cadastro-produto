package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/*** Conexão com banco de dados ***/
	// Parâmetros de conexão
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/dbisaclube?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "";

	// Método de conexão
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
				
				//Abrir conexão com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
				pst.setString(1, produtos.getTipo());
				pst.setString(2, produtos.getNomeproduto());
				pst.setString(3, produtos.getDescricao());
				pst.setString(4, produtos.getPreco());
				pst.setString(5, produtos.getIdfoto());
				
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conexão com banco de dados
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
				//Abrir conexão com Banco
				Connection con = conectar();
				// Prepara a query
				PreparedStatement pst = con.prepareStatement(create);
				//substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
								
				pst.setString(1, fotos.getFoto1());
				pst.setString(2, fotos.getFoto2());
				pst.setString(3, fotos.getFoto3());
				pst.setString(4, fotos.getFoto4());
				
												
				//Executa a query (comando sql)
				pst.executeUpdate();
				// IMPORTANTE !!! fecha a conexão com banco de dados
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		
		
		/*  CRUD - Read Produto*/
		// método com retorno usando oArryList ligado ao JavaBeans
		public ArrayList<JavaBeans> listarProduto(){
			// criar um vetor dinamico para receber as variaveis, que serão armazenada em JavaBeans 
			 ArrayList<JavaBeans> produto = new ArrayList<>();
			//query
			String read = "select p.idproduto, p.tipo, p.nomeproduto, p.descricao, p.preco,p.idfoto, f.foto1, f.foto2,f.foto3,f.foto4  \r\n" + 
					"       from produto p inner join foto f on p.idfoto=f.idfoto where idproduto=idproduto";
			try {
				//abrir a conexão
				Connection con = conectar();
				// Prepara a query
				 PreparedStatement pst = con.prepareStatement(read);
				 //Executar a query
				 ResultSet rs = pst.executeQuery(); // (2)
				 // Laço de repetição que sera executado enquanto houver clientes
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
					
					 //fechar a conexão
					//con.close();
				 }
				 return produto;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		/*  CRUD - Read Foto*/
		// método com retorno usando oArryList ligado ao JavaBeans
		public ArrayList<JavaBeans> listarFoto(){
			// criar um vetor dinamico para receber as variaveis, que serão armazenada em JavaBeans 
			 ArrayList<JavaBeans> foto = new ArrayList<>();
			//query
			String read = "select p.idfoto, f.foto1, f.foto2,f.foto3,f.foto4,p.idproduto, p.nomeproduto, p.descricao, p.preco \r\n" + 
					"     from produto p inner join foto f on p.idfoto=f.idfoto where idproduto=idproduto";
			try {
				//abrir a conexão
				Connection con = conectar();
				// Prepara a query
				 PreparedStatement pst = con.prepareStatement(read);
				 //Executar a query
				 ResultSet rs = pst.executeQuery(); // (2)
				 // Laço de repetição que sera executado enquanto houver Foto
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
		// Update 1 - Método para selecionar o contato
		public void listarProduto(JavaBeans produtos) {
			// query
			String update1 = "select * from produto where idproduto=?";
			try {
				// abrir a conexão
				Connection con = conectar();
				// Preparar a query
				PreparedStatement pst = con.prepareStatement(update1);
				// Substituir  o parâmetro (?) pelo conteúdo no objeto rs
				pst.setString(1, produtos.getIdproduto()); //(4)
				// Executa a query, armazenando o conteúdo no objeto rs
				ResultSet rs = pst.executeQuery(); //(5)
				// Laço de repetição que será executatdo enquanto houver contatos
				while (rs.next()) {
					// teste de recebimento  // (6)
					//System.out.println(rs.getString(1));
					// Setar as variáveis javaBeans com o select (banco de dados)passo (6)(7)
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
		// Update 2 - Método para Alterar o contato
			public void alterarProduto(JavaBeans produtos) {
				// query
				String update2 = "update produto set tipo=?, nomeproduto=?, descricao=?,preco=? where idproduto=?";
				try {
				// abrir a conexão
				Connection con = conectar();
				// Prepare a query
				PreparedStatement pst = con.prepareStatement(update2);
				// substituir os parâmetros(?) pelo conteúdo javaBeans (14)
				pst.setString(1, produtos.getTipo());
				pst.setString(2, produtos.getNomeproduto());
				pst.setString(3, produtos.getDescricao());
				pst.setString(4, produtos.getPreco());
				pst.setString(5, produtos.getIdproduto());
				// executa a query
				pst.executeUpdate(); //(15)
				//fechar a conexão
				con.close();
							
				} catch (Exception e) {
				System.out.println(e);					
		}					
	}
			/* CRUD- Update */
			// Update 1 - Método para selecionar o contato
			public void listarFoto(JavaBeans fotos) {
			// query
			String update3 = "select * from foto where idfoto=?";
			try {
			// abrir a conexão
			Connection con = conectar();
				// Preparar a query
				PreparedStatement pst = con.prepareStatement(update3);
				// Substituir  o parâmetro (?) pelo conteúdo no objeto rs
				pst.setString(1, fotos.getIdfoto()); //(4)
				// Executa a query, armazenando o conteúdo no objeto rs
				ResultSet rs = pst.executeQuery(); //(5)
				// Laço de repetição que será executatdo enquanto houver contatos
				while (rs.next()) {
				// teste de recebimento  // (6)
				//System.out.println(rs.getString(1));
				// Setar as variáveis javaBeans com o select (banco de dados)passo (6)(7)
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

			
			
		// Update 2 - Método para Alterar o contato
		public void alterarFoto(JavaBeans fotos) {
		// query
		String update4 = "update foto set foto1=?, foto2=?,foto3=?,foto4=? where idfoto=?";
		try {
		// abrir a conexão
		Connection con = conectar();
		// Prepare a query
		PreparedStatement pst = con.prepareStatement(update4);
		// substituir os parâmetros(?) pelo conteúdo javaBeans (14)
		pst.setString(1,  fotos.getFoto1());
		pst.setString(2,  fotos.getFoto2());
		pst.setString(3,  fotos.getFoto3());
		pst.setString(4,  fotos.getFoto4());
		pst.setString(5,  fotos.getIdfoto());
		// executa a query
		pst.executeUpdate(); //(15)
		//fechar a conexão
		con.close();
				
		} catch (Exception e) {
		System.out.println(e);					
			
		}					
	}
		
		// Update 1 - Método para selecionar o contato
		public ArrayList<JavaBeans> listarIdfoto(){
			 ArrayList<JavaBeans> foto = new ArrayList<>();
		// query
		String read = "select * from foto order by idfoto desc limit 0,1";
		try {
		// abrir a conexão
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
		

			
		
		


}
