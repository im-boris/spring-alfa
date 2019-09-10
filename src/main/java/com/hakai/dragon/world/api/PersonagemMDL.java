package com.hakai.dragon.world.api;


//@Entity
//@Table(name = "Nome_Tabela_Banco")
public class PersonagemMDL {
	
	
	private int id;
	private String urlFoto;
	private String nome;
	private String categoria;
	private String fraseEfeito;
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
//	@Column(name = "urlFoto", length = 80)
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
//  @Column(name = "nome", length = 80)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
//	@Column(name = "categoria", length = 80)
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
//	@Column(name = "frase", length = 80)
	public String getFraseEfeito() {
		return fraseEfeito;
	}
	public void setFraseEfeito(String fraseEfeito) {
		this.fraseEfeito = fraseEfeito;
	}
	
	

}
