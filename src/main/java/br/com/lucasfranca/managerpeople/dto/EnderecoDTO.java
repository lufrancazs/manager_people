package br.com.lucasfranca.managerpeople.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private boolean enderecoPrincipal;
	private String logradouro;
	private String cidade;
	private String estado;
	private String pais;
	private String codigoPostal;
	
	
	public EnderecoDTO() {
		
	}

	public EnderecoDTO(Long id, boolean enderecoPrincipal, String logradouro, String cidade, String estado, String pais, String codigoPostal) {
		super();
		this.id = id;
		this.enderecoPrincipal = enderecoPrincipal;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}	
	

}
