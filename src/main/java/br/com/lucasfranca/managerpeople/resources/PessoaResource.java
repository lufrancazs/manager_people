package br.com.lucasfranca.managerpeople.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
