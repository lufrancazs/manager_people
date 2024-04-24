package br.com.lucasfranca.managerpeople.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.lucasfranca.managerpeople.dto.PessoaDTO;
import br.com.lucasfranca.managerpeople.services.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	public List<PessoaDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
		PessoaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> insertPessoa(@RequestBody PessoaDTO pessoa){
		pessoa = service.insertPessoa(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoa);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
		
		service.deletePessoa(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Long id, @RequestBody PessoaDTO dto){
		dto = service.updatePessoa(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
