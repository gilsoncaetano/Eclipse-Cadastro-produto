package model;

public class JavaBeans {
	private String idproduto;
	private String tipo;
	private String nomeproduto;
	private String descricao;
	private String preco;
	private String idfoto;
	private String foto1;
	private String foto2;
	private String foto3;
	private String foto4;
	
	//construtor padrão
		public JavaBeans() {
		
		}
	
	public JavaBeans(String idproduto, String tipo, String nomeproduto, String descricao, String preco, String idfoto, String foto1,
			String foto2, String foto3, String foto4) {
	
	this.idproduto = idproduto;
	this.tipo = tipo;
	this.nomeproduto = nomeproduto;
	this.descricao = descricao;
	this.preco = preco;
	this.idfoto = idfoto;
	this.foto1 = foto1;
	this.foto2 = foto2;
	this.foto3 = foto3;
	this.foto4 = foto4;

	
	}
	
	public JavaBeans(String idfoto, String foto1, String foto2, String foto3, String foto4) {
	
		this.idfoto = idfoto;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.foto4 = foto4;
	}

	public JavaBeans(String idfoto) {
		this.idfoto = idfoto;
	}

		// Produto
		public String getIdproduto() {
			return idproduto;
		}
		public void setIdproduto(String idproduto) {
			this.idproduto = idproduto;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getNomeproduto() {
			return nomeproduto;
		}
		public void setNomeproduto(String nomeproduto) {
			this.nomeproduto = nomeproduto;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getPreco() {
			return preco;
		}
		public void setPreco(String preco) {
			this.preco = preco;
		}
		public String getIdfoto() {
			return idfoto;
		}
		public void setIdfoto(String idfoto) {
			this.idfoto = idfoto;
		}
		public String getFoto1() {
			return foto1;
		}
		public void setFoto1(String foto1) {
			this.foto1 = foto1;
		}
		public String getFoto2() {
			return foto2;
		}
		public void setFoto2(String foto2) {
			this.foto2 = foto2;
		}
		public String getFoto3() {
			return foto3;
		}
		public void setFoto3(String foto3) {
			this.foto3 = foto3;
		}
		public String getFoto4() {
			return foto4;
		}
		public void setFoto4(String foto4) {
			this.foto4 = foto4;
		}

				
}
