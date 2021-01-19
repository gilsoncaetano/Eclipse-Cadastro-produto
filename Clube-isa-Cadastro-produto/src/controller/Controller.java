package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller","/insert","/insert1","/update1", "/update2","/update3", "/update4","/update5", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		//Criar objeto para acessar os métodos javaBeans (Model)
		JavaBeans produtos = new JavaBeans();
		JavaBeans fotos = new JavaBeans();	
		JavaBeans idfot = new JavaBeans();
		//Criar objeto para acessa os métodos DAO(model)
		DAO dao = new DAO();
		DAO daofot = new DAO(); 
		DAO daoidfot = new DAO(); 
		
	    public Controller() {
	        super();
	       
	    }

			/** Método pricipal do Select (Controller) **/
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
				// Trabalhar com rotas
				String action = request.getServletPath();
			
			if (action.contentEquals("/insert")) {
				novoProduto(request,response);	
			}if (action.contentEquals("/insert1")) {
				novoFoto(request,response);
			} else if (action.contentEquals("/update1")) {
				editarProduto(request, response);
			} else if (action.contentEquals("/update2")) {
				editarProduto2(request, response);
			} else if (action.contentEquals("/update3")) {
				editarFoto(request, response);
			} else if (action.contentEquals("/update4")) {
				editarFoto2(request, response);
			} else if (action.contentEquals("/update5")) {
				cadastroPro(request, response);
			
		}
	}
		
		/** Método para Cadastrar Produto**/
		protected void novoProduto(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			// Método Pricipal do Servle
					/*** Passo "4" ***/
					// As Variáves abaixo recebem ps parâmetros do formulário contato.jsp
					String tipo = request.getParameter("tipo");
					String nomeproduto = request.getParameter("nomeproduto");
					String descricao = request.getParameter("descricao");
					String preco = request.getParameter("preco");			
					String idfoto = request.getParameter("idfoto");
					
					
					// Star as variáveis da classe JavaBeans
					produtos.setTipo(tipo);
					produtos.setIdfoto(idfoto);
					produtos.setNomeproduto(nomeproduto);
					produtos.setDescricao(descricao);
					produtos.setPreco(preco);
					
					
					dao.novoProduto(produtos);
					//daofot.novofoto(foto);
					response.sendRedirect("index.jsp");
			
		}
		
		/** Método para Cadastrar Foto**/
		protected void novoFoto(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			// Método Pricipal do Servle
					/*** Passo "4" ***/
					// As Variáves abaixo recebem ps parâmetros do formulário contato.jsp
					String foto1 = request.getParameter("foto1");
					String foto2 = request.getParameter("foto2");
					String foto3 = request.getParameter("foto3");
					String foto4 = request.getParameter("foto4");
					//String idfoto = request.getParameter("idfoto");
					
					// Star as variáveis da classe JavaBeans
					fotos.setFoto1(foto1);
					fotos.setFoto2(foto2);
					fotos.setFoto3(foto3);
					fotos.setFoto4(foto4);
					
					//fotos.setIdfoto(idfoto);
					
					//*** Passo "4" ***/
					// "Dar a ordem para o DAO executa o método novoClientes()"
					//RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
					//rd.forward(request, response);
					daofot.novoFoto(fotos);
					//daofot.listarFoto(fotos);
					
					//request.setAttribute("idfoto", fotos.getIdfoto());
					response.sendRedirect("foto.jsp");
					//RequestDispatcher rd = request.getRequestDispatcher("cadastroPro.jsp");
					//rd.forward(request, response);
					
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/** Método para Editar Produto **/
	// select do Produto (update 1)
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idproduto = request.getParameter("idproduto");
		
		produtos.setIdproduto(idproduto);
		// invocar o método para selecionar o contato que será alterado (3)
		dao.listarProduto(produtos);
		// encaminha oconteúdo JavaBeans ao formulario editar.jsp (8)
		request.setAttribute("tipo", produtos.getTipo());
		request.setAttribute("idproduto", produtos.getIdproduto());
		request.setAttribute("nomeproduto", produtos.getNomeproduto());
		request.setAttribute("descricao", produtos.getDescricao());
		request.setAttribute("preco", produtos.getPreco());
		
		// executar encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editarPro.jsp");
		rd.forward(request, response);
	}

	/** Método para Editar Produto2**/
	//update do Produto 2
	protected void editarProduto2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//setar as variaveis JavaBean com o formulario do formulario 
		produtos.setTipo(request.getParameter("tipo"));
		produtos.setIdproduto(request.getParameter("idproduto"));
		produtos.setNomeproduto(request.getParameter("nomeproduto"));
		produtos.setDescricao(request.getParameter("descricao"));
		produtos.setPreco(request.getParameter("preco"));
		
		//invocar o método que vai atualizar cliente no banco de dados 
		dao.alterarProduto(produtos);
		response.sendRedirect("index.jsp");	
	}
	
	/** Método para Editar Foto **/
	// select do Foto (update 3)
	protected void editarFoto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idfoto = request.getParameter("idfoto");
		fotos.setIdfoto(idfoto);
		// invocar o método para selecionar o contato que será alterado (3)
		daofot.listarFoto(fotos);
		// encaminha oconteúdo JavaBeans ao formulario editarfoto.jsp (8)
		request.setAttribute("idfoto", fotos.getIdfoto());
		request.setAttribute("foto1", fotos.getFoto1());
		request.setAttribute("foto2", fotos.getFoto2());
		request.setAttribute("foto3", fotos.getFoto3());
		request.setAttribute("foto4", fotos.getFoto4());
		// executar encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("editarFoto.jsp");
		rd.forward(request, response);
	}
	
	/** Método para Editar Foto2**/
	//update do Foto 2
	protected void editarFoto2(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//setar as variaveis JavaBean com o formulario do formulario 
		fotos.setIdfoto(request.getParameter("idfoto"));
		fotos.setFoto1(request.getParameter("foto1"));
		fotos.setFoto2(request.getParameter("foto2"));
		fotos.setFoto3(request.getParameter("foto3"));
		fotos.setFoto4(request.getParameter("foto4"));
		//invocar o método que vai atualizar cliente no banco de dados 
		daofot.alterarFoto(fotos);
		response.sendRedirect("index.jsp");	
	}

	/** Método para Lista  **/
	// select do Foto (update 3)
	protected void cadastroPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idfoto = request.getParameter("idfoto");
		fotos.setIdfoto(idfoto);
		// invocar o método para selecionar o contato que será alterado (3)
		daofot.listarFoto(fotos);
		// encaminha oconteúdo JavaBeans ao formulario editarfoto.jsp (8)
		request.setAttribute("idfoto", fotos.getIdfoto());
		request.setAttribute("foto3", fotos.getFoto3());
		request.setAttribute("foto1", fotos.getFoto1());
		request.setAttribute("foto2", fotos.getFoto2());
		request.setAttribute("foto4", fotos.getFoto4());
		// executar encaminhamento
		RequestDispatcher rd = request.getRequestDispatcher("cadastroPro.jsp");
		rd.forward(request, response);
	}	
}
