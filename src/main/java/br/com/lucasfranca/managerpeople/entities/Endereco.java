package br.com.lucasfranca.managerpeople.entities;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private String cidade;
	private String estado;
	private String pais;
	private String codigoPostal;
	
	public Endereco() {
		
	}
	
	
	public Endereco(Long id, String logradouro, String cidade, String estado, String pais, String codigoPostal) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
