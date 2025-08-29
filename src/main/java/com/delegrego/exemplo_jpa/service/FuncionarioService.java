package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

// TODO: Tirar todos os métodos que são "auxiliares"?

/**
 * Serviço para gerenciar operações relacionadas a funcionários.
 */

// Indica que esta classe é um serviço do Spring (camada de lógica de negócio)
@Service
public class FuncionarioService {

	// Autowired injeta automaticamente a interface de repositório que acessa o
	// banco de dados
	@Autowired
	private FuncionarioRepository repo;

	@Autowired
	private DepartamentoService departamentoServico;

	/**
	 * Create: Cadastra um novo funcionário no sistema.
	 * 
	 * @param f - O funcionário a ser cadastrado.
	 * @throws RuntimeException se já existir um funcionário com o mesmo CPF ou se o
	 *                          departamento não existir.
	 */
	public void cadastrarFuncionario(Funcionario f) {

		if (obterFuncionarioPorCpf(f.getCpf()).isPresent()) {
			throw new RuntimeException("Já existe um funcionário com esse cpf");
		}

		departamentoServico.obterDepartamentoPorId(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		repo.save(f);
	}

	/**
	 * Read: Lista todos os funcionários cadastrados no sistema.
	 * 
	 * @return Uma lista de funcionários.
	 */
	public List<Funcionario> listarFuncionarios() {
		return repo.findAll();
	}

	// TODO: Tirar?
	/**
	 * Obtém um funcionário pelo seu ID.
	 * 
	 * @param id - O ID do funcionário a ser buscado.
	 * @return Um Optional contendo o funcionário, se encontrado.
	 */
	public Optional<Funcionario> obterFuncionarioPorId(int id) {
		return repo.findById(id);
	}

	/**
	 * Obtém um funcionário pelo seu CPF.
	 * 
	 * @param cpf - O CPF do funcionário a ser buscado.
	 * @return Um Optional contendo o funcionário, se encontrado.
	 */
	public Optional<Funcionario> obterFuncionarioPorCpf(String cpf) {
		return repo.findByCpf(cpf);
	}

	/**
	 * Update: Atualiza as informações de um funcionário existente.
	 * 
	 * @param f - O funcionário com as informações atualizadas.
	 * @throws RuntimeException se o funcionário não existir, se já existir outro
	 *                          funcionário com o mesmo CPF, ou se o departamento
	 *                          não existir.
	 */
	public void atualizarFuncionario(Funcionario f) {
		obterFuncionarioPorId(f.getIdFuncionario()).orElseThrow(() -> new RuntimeException("Funcionário não existe"));

		if (repo.existsByCpfAndIdFuncionarioNot(f.getCpf(), f.getIdFuncionario())) {
			throw new RuntimeException("Usuário com esse email já existe");
		}

		departamentoServico.obterDepartamentoPorId(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		repo.save(f);
	}

	/**
	 * Delete: Deleta um funcionário pelo seu ID.
	 * 
	 * @param id - O ID do funcionário a ser deletado.
	 * @throws RuntimeException se o funcionário não existir.
	 */
	public void deletarFuncionario(int id) {
		departamentoServico.obterDepartamentoPorId(id)
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		repo.deleteById(id);
	}

	public int obterFuncionariosPorDepartamento(int id) {
		return repo.countByDepartamento_IdDepartamento(id);
	}

}
