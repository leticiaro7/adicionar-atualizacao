package com.testeaula6.Aula06.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testeaula6.Aula06.modelo.Contato;
import com.testeaula6.Aula06.servico.ContatoServico;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/aula") // This means URL's start with /demo (after Application
public class ContatoControle {

	@Autowired
	ContatoServico contatoRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public ResponseEntity<String> addContato(@RequestBody Contato contato) {
		try {
			contatoRepository.salvar(contato);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("OK");

	}
	@GetMapping(path = "/get") // Map ONLY POST Requests
	public ResponseEntity<List<Contato>> getAll() {
		try {
			var lista  =  contatoRepository.listar();
			return ResponseEntity.ok(lista);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@PutMapping(path = "/update") // Map ONLY POST Requests
	public ResponseEntity<Contato> update(@RequestBody Contato contato, @RequestParam Long id) {
		try {
			return ResponseEntity.ok(new Contato());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping(path = "/delete") // Map ONLY POST Requests
	public ResponseEntity<String> delete(@RequestParam Long id) {
		try {
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
