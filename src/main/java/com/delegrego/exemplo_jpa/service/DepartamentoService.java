package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Departamento;
import com.delegrego.exemplo_jpa.repo.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository repo;

	public void cadastrarDepartamento(Departamento d) {
		repo.save(d);
	}

	
	public List<Departamento> listarDepartamentos() {
		// TODO: Mudar a mensagem caso não tenha nenhum departamento?
		return repo.findAll();
	}

	// TODO: Tirar?
	public Optional<Departamento> obterDepartamentoPorId(int id) {
		return repo.findById(id);
	}

	// TODO: Lançar um erro caso o departamento a ser modificado não exista
	public void atualizarDepartamento(Departamento d) {
		repo.save(d);
	}

	// TODO: Lançar um erro caso o departamento a ser removido não exista?
	// TODO: Lançar um erro caso o departamento tenha funcionários inseridos nele
	public void deletarDepartamento(int id) {
		repo.deleteById(id);
	}
}
