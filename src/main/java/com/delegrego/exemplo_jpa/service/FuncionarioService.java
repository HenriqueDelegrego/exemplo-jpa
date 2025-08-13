package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	private DepartamentoService departamentoServico;

	public void cadastrarFuncionario(Funcionario f) {

		if (obterFuncionarioPorCpf(f.getCpf()).isPresent()) {
			throw new RuntimeException("Já existe um funcionário com esse cpf");
		}

		departamentoServico.obterDepartamentoPorId(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));
		repo.save(f);
	}

	public List<Funcionario> listarFuncionarios() {
		return repo.findAll();
	}

	// TODO: Tirar?
	public Optional<Funcionario> obterFuncionarioPorId(int id) {
		return repo.findById(id);
	}

	public Optional<Funcionario> obterFuncionarioPorCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

	// TODO: Lançar um erro caso o funcionário a ser modificado não exista
	// TODO: Lançar um erro caso o cpf a ser colocado já existe
	// TODO: Lançar um erro caso o departamento a ser colocado não existe
	public void atualizarFuncionario(Funcionario f) {
		repo.save(f);
	}

	// TODO: Lançar um erro caso o departamento a ser removido não exista?
	public void deletarFuncionario(int id) {
		repo.deleteById(id);
	}

	public int contarFuncionarios(int id) {
		return repo.countByDepartamento_IdDepartamento(id);
	}

}
