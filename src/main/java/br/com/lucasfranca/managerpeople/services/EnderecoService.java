package br.com.lucasfranca.managerpeople.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.lucasfranca.managerpeople.dto.EnderecoDTO;
import br.com.lucasfranca.managerpeople.entities.Endereco;
import br.com.lucasfranca.managerpeople.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public List<EnderecoDTO> findAll(){
		 return repository.findAll().stream()
				 .map(p -> modelMapper.map(p, EnderecoDTO.class))
				 .collect(Collectors.toList());	
		 }
	
	public EnderecoDTO findById(Long id) {
		Endereco endereco = repository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		
		return modelMapper.map(endereco, EnderecoDTO.class);
	}
	
	public EnderecoDTO insertEndereco(EnderecoDTO dto) {
		Endereco endereco = modelMapper.map(dto, Endereco.class);
		
		repository.save(endereco);
		return modelMapper.map(endereco, EnderecoDTO.class);
	}
	
	public void deleteEndereco(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}
}
