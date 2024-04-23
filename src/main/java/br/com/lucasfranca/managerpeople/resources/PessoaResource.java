package br.com.lucasfranca.managerpeople.resources;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasfranca.managerpeople.entities.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@GetMapping
	public ResponseEntity<Pessoa> findAll(){
		Pessoa p = new Pessoa(1L, "Maria", LocalDate.parse("2020-10-10"));
		return ResponseEntity.ok().body(p);
	}

}
