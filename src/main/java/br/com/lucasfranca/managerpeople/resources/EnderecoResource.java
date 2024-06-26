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

import br.com.lucasfranca.managerpeople.dto.EnderecoDTO;
import br.com.lucasfranca.managerpeople.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> findAll() {
		List<EnderecoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
		EnderecoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
	@GetMapping(value = "/principal/pessoas/{pessoaId}")
	public ResponseEntity<EnderecoDTO> findEnderecoPrincipal(@PathVariable Long pessoaId) {
		EnderecoDTO dto = service.findEnderecoPrincipal(pessoaId);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> insertEndereco(@RequestBody EnderecoDTO endereco) {
		endereco = service.insertEndereco(endereco);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();

		return ResponseEntity.created(uri).body(endereco);
	}
	
	@PostMapping(value = "/{pessoaId}")
	public ResponseEntity<EnderecoDTO> insertEnderecoPessoa(@PathVariable Long pessoaId, @RequestBody EnderecoDTO endereco){
		endereco = service.insertEnderecoPessoa(pessoaId, endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();

		return ResponseEntity.created(uri).body(endereco);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deletePessoa(@PathVariable Long id){
		
		service.deleteEndereco(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO dto){
		dto = service.updateEndereco(id, dto);
		return ResponseEntity.ok().body(dto);
	}

}
