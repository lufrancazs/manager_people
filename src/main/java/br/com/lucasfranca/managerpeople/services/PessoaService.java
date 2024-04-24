package br.com.lucasfranca.managerpeople.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.lucasfranca.managerpeople.dto.PessoaDTO;
import br.com.lucasfranca.managerpeople.entities.Pessoa;
import br.com.lucasfranca.managerpeople.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

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
	
	public PessoaDTO findById(Long id) {
		Pessoa pessoa = repository.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	public PessoaDTO insertPessoa(PessoaDTO dto) {
		Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
		
		repository.save(pessoa);
		return modelMapper.map(pessoa, PessoaDTO.class);
	}
	
	public void deletePessoa(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new EntityNotFoundException(e.getMessage());
		}
	}
	
	public PessoaDTO updatePessoa(Long id, PessoaDTO dto) {
		
			Pessoa pessoa = repository.getReferenceById(id);
			
			if (pessoa == null) {
				throw new EntityNotFoundException();
			}
			
			updateData(pessoa, dto);
			return modelMapper.map(repository.save(pessoa), PessoaDTO.class);
	}
	
	private void updateData(Pessoa pessoa, PessoaDTO dto) {
		pessoa.setNome(dto.getNome());
		pessoa.setDataNascimento(dto.getDataNascimento());
	}
	
}
