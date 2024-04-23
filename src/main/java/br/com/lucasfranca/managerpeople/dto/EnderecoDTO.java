package br.com.lucasfranca.managerpeople.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private String cidade;
	private String estado;
	private String pais;
	private String codigoPostal;
	
	private PessoaDTO pessoa;
	
	public EnderecoDTO() {
		
	}

	public EnderecoDTO(Long id, String logradouro, String cidade, String estado, String pais, String codigoPostal, PessoaDTO pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
