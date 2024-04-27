package br.com.lucasfranca.managerpeople.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.lucasfranca.managerpeople.dto.EnderecoDTO;
import br.com.lucasfranca.managerpeople.entities.Endereco;
import br.com.lucasfranca.managerpeople.entities.Pessoa;
import br.com.lucasfranca.managerpeople.repositories.EnderecoRepository;
import br.com.lucasfranca.managerpeople.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;	
	

	@Autowired
	private ModelMapper modelMapper;

	public List<EnderecoDTO> findAll() {
		return repository.findAll().stream().map(p -> modelMapper.map(p, EnderecoDTO.class))
				.collect(Collectors.toList());
	}

	public EnderecoDTO findById(Long id) {
		Endereco endereco = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Não encontrado o ID: '" + id + "'"));

		return modelMapper.map(endereco, EnderecoDTO.class);
	}
	
	public EnderecoDTO findEnderecoPrincipal(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
		
		
		Endereco enderecoPrincipal = pessoa.getEndereco().stream()
				.filter(Endereco::isEnderecoPrincipal)
				.findFirst()
				.orElseThrow(() -> new EntityNotFoundException("Endereço principal não encontrado para a pessoa com ID: " + id));
		
		return modelMapper.map(enderecoPrincipal, EnderecoDTO.class);
	}

	public EnderecoDTO insertEndereco(EnderecoDTO dto) {
		Endereco endereco = modelMapper.map(dto, Endereco.class);

		repository.save(endereco);
		return modelMapper.map(endereco, EnderecoDTO.class);
	}

	public EnderecoDTO insertEnderecoPessoa(Long pessoaId, EnderecoDTO dto) {
		List<Endereco> enderecos = repository.findByPessoaId(pessoaId);
		Endereco endereco = modelMapper.map(dto, Endereco.class);

		if (enderecos.isEmpty()) {
			endereco.setEnderecoPrincipal(true);
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaId);
		endereco.setPessoa(pessoa);

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

	public EnderecoDTO updateEndereco(Long id, EnderecoDTO dto) {

		Endereco endereco = repository.getReferenceById(id);

		if (endereco == null) {
			throw new EntityNotFoundException();
		}

		updateData(endereco, dto);
		return modelMapper.map(repository.save(endereco), EnderecoDTO.class);
	}

	private void updateData(Endereco endereco, EnderecoDTO dto) {
		endereco.setEnderecoPrincipal(dto.isEnderecoPrincipal());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setCidade(dto.getCidade());
		endereco.setEstado(dto.getEstado());
		endereco.setPais(dto.getPais());
		endereco.setCodigoPostal(dto.getCodigoPostal());
	}
	
}
