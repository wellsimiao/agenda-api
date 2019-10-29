package com.webagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webagenda.dao.ContatoDto;
import com.webagenda.model.Contato;
import com.webagenda.service.ContatoService;

@RestController
@RequestMapping(value= "contato")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ContatoDto> save(@RequestBody ContatoDto dto) {
		Contato contato = contatoService.converterToContato(dto);
		contato = contatoService.save(contato);
		dto = contatoService.converterToContatoDto(contato);
		return ResponseEntity.ok().body(dto);
    }
	@RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<ContatoDto>> findAll(){
		List<ContatoDto> dtos = contatoService.converterToContatoDto(contatoService.findAll());
		return ResponseEntity.ok().body(dtos);
	}
	/*
	@RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		ContatoService.delete(id);
		return ResponseEntity.ok().build();
	}
	*/

}
