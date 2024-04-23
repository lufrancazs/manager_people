package br.com.lucasfranca.managerpeople.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PessoaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	
	private Long enderecoPrincipalId;
	
	public PessoaDTO() {

	}

	public PessoaDTO(Long id, String nome, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getEnderecoPrincipalId() {
		return enderecoPrincipalId;
	}

	public void setEnderecoPrincipalId(Long enderecoPrincipalId) {
		this.enderecoPrincipalId = enderecoPrincipalId;
	}

	

}
