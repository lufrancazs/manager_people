package br.com.lucasfranca.managerpeople.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasfranca.managerpeople.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	List<Endereco> findByPessoaId(Long id);

}
