package com.webagenda.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.webagenda.dao.ContatoDto;
import com.webagenda.model.Contato;
import com.webagenda.model.Telefone;
import com.webagenda.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	public Contato save(@Validated Contato contato) {
		contato.setDataCadastro(new Date());
		return contatoRepository.save(contato);
	}

	public Optional<Contato> findById(Integer id) {
		return contatoRepository.findById(id);
	}

	public Iterable<Contato> findAll() {
		return contatoRepository.findAll();
	}

	/*public  void delete(Integer id) {
        contatoRepository.delete(id);
    }
*/
	public Contato converterToContato(ContatoDto dto) {
		Contato contato = new Contato();
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		List<Telefone> telefones = new ArrayList<Telefone>();
		for (ContatoDto.TelefoneDto telefoneDto : dto.getTelefone()) {
			Telefone telefone = new Telefone();
			telefone.setNumero(telefoneDto.getNumero());
			telefone.setDdd(telefoneDto.getDdd());
			telefone.setContato(contato);
			telefones.add(telefone);
		}
		contato.setTelefone(telefones);
		return contato;
	}

	public ContatoDto converterToContatoDto(Contato contato) {
		ContatoDto contatoDto = new ContatoDto();
		contatoDto.setNome(contato.getNome());
		contatoDto.setEmail(contato.getEmail());
		contatoDto.setDataCadastro(contato.getDataCadastro());
		List<ContatoDto.TelefoneDto> telefonesDto = new ArrayList<ContatoDto.TelefoneDto>();
		for (Telefone telefone : contato.getTelefone()) {
			ContatoDto.TelefoneDto telefoneDto = new ContatoDto.TelefoneDto();
			telefoneDto.setNumero(telefone.getNumero());
			telefoneDto.setDdd(telefone.getDdd());
			telefonesDto.add(telefoneDto);
		}
		contatoDto.setTelefone(telefonesDto);
		return contatoDto;
	}

	public List<ContatoDto> converterToContatoDto(Iterable<Contato> contatos) {
		List<ContatoDto> contatosDto = new ArrayList<ContatoDto>();
		for (Contato contato : contatos) {
			ContatoDto contatoDto = converterToContatoDto(contato);
			contatosDto.add(contatoDto);
		}
		return contatosDto;
	}
}
