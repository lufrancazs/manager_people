package br.com.lucasfranca.managerpeople.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasfranca.managerpeople.dto.PessoaDTO;
import br.com.lucasfranca.managerpeople.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<PessoaDTO> findAll(){
		 return repository.findAll().stream()
				 .map(p -> modelMapper.map(p, PessoaDTO.class))
				 .collect(Collectors.toList());	
		 }
}
