package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository repo;

	@Autowired
	public FuncionarioService(FuncionarioRepository repo) {
		this.repo = repo;
	}

	public void cadastrarFuncionario(Funcionario f) {
		repo.save(f);
	}

	public List<Funcionario> listarFuncionarios() {
		return repo.findAll();
	}

	public Optional<Funcionario> obterFuncionarioPorId(int id) {
		return repo.findById(id);
	}

	public Optional<Funcionario> obterFuncionarioPorCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

	public void atualizarFuncionario(Funcionario f) {
		repo.save(f);
	}

	public void deletarFuncionario(int id) {
		repo.deleteById(id);
	}

	public int contarFuncionarios(int id) {
		return repo.countByDepartamento_IdDepartamento(id);
	}

}
