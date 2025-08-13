package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

// TODO: Tirar todos os métodos que são "auxiliares"?

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;

	@Autowired
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

	public Optional<Funcionario> obterFuncionarioPorId(int id) {
		return repo.findById(id);
	}

	public Optional<Funcionario> obterFuncionarioPorCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

	public void atualizarFuncionario(Funcionario f) {
		obterFuncionarioPorId(f.getIdFuncionario()).orElseThrow(() -> new RuntimeException("Funcionário não existe"));

		if (repo.existsByCpfAndIdFuncionarioNot(f.getCpf(), f.getIdFuncionario())) {
			throw new RuntimeException("Usuário com esse email já existe");
		}

		departamentoServico.obterDepartamentoPorId(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		repo.save(f);
	}

	public void deletarFuncionario(int id) {

		departamentoServico.obterDepartamentoPorId(id)
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		repo.deleteById(id);
	}

	public int contarFuncionarios(int id) {
		return repo.countByDepartamento_IdDepartamento(id);
	}

}
