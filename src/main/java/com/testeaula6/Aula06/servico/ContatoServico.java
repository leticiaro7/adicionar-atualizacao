package com.testeaula6.Aula06.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeaula6.Aula06.interfaces.ContatoInterface;
import com.testeaula6.Aula06.modelo.Contato;

@Service
public class ContatoServico {

	@Autowired
	ContatoInterface repository;
	
	public void salvar(Contato contato ) throws Exception {
		try {
			repository.save(contato);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Contato> listar() throws Exception {
		try {
			return (List<Contato>) repository.findAll();
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void alterar(Contato contato, Long id) throws Exception {
		try {
			Optional<Contato> objeto = repository.findById(id);
			objeto.get().setNome(contato.getNome());
			objeto.get().setSexo(contato.getSexo());
			objeto.get().setTelefone(contato.getTelefone());
			
			repository.save(objeto.get());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void delatar(Long id) throws Exception {
		try {
			repository.deleteById(id);
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
