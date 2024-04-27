package br.com.lucasfranca.managerpeople.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lucasfranca.managerpeople.entities.Endereco;
import br.com.lucasfranca.managerpeople.entities.Pessoa;
import br.com.lucasfranca.managerpeople.repositories.EnderecoRepository;
import br.com.lucasfranca.managerpeople.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		
	Pessoa p1 = new Pessoa(null, "Maria Brown", LocalDate.parse("1996-10-09"));
	Pessoa p2 = new Pessoa(null, "João Green", LocalDate.parse("1990-02-19"));
	Pessoa p3 = new Pessoa(null, "Isabel Yellow", LocalDate.parse("1994-08-02"));
	Pessoa p4 = new Pessoa(null, "Alex Blue", LocalDate.parse("1999-06-01"));
	
	pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	
	Endereco e1 = new Endereco(null, true,"Rua Gasparini, 200", "São Bernardo do Campo", "São Paulo", "Brasil", "09635130", p1);
	Endereco e2 = new Endereco(null, true, "Av. Senador Vergueiro, 1000", "São Bernardo do Campo", "São Paulo", "Brasil", "09750230", p2);
	Endereco e3 = new Endereco(null, true, "Av Pres. Kennedy, 800", "São Caetano do Sul", "São Paulo", "Brasil", "09570000", p3);
	
	enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
	}
	
}
