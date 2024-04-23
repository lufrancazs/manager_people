package br.com.lucasfranca.managerpeople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasfranca.managerpeople.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
