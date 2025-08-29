package com.delegrego.exemplo_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.repo.DepartamentoRepository;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

/**
 * Serviço para gerenciar operações relacionadas a funcionários.
 */

// Indica que esta classe é um serviço do Spring (camada de lógica de negócio)
@Service
public class FuncionarioService {

	// Autowired injeta automaticamente a interface de repositório que acessa o
	// banco de dados
	@Autowired
	private FuncionarioRepository funcionarioRepo;

	@Autowired
	private DepartamentoRepository departamentoRepo;

	/**
	 * Create: Cadastra um novo funcionário no sistema.
	 * 
	 * @param f - O funcionário a ser cadastrado.
	 * @throws RuntimeException se já existir um funcionário com o mesmo CPF ou se o
	 *                          departamento não existir.
	 */
	public void cadastrarFuncionario(Funcionario f) {

		if (funcionarioRepo.findByCpf(f.getCpf()).isPresent()) {
			throw new RuntimeException("Já existe um funcionário com esse cpf");
		}

		departamentoRepo.findById(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		funcionarioRepo.save(f);
	}

	/**
	 * Read: Lista todos os funcionários cadastrados no sistema.
	 * 
	 * @return Uma lista de funcionários.
	 */
	public List<Funcionario> listarFuncionarios() {
		return funcionarioRepo.findAll();
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
		funcionarioRepo.findById(f.getIdFuncionario())
				.orElseThrow(() -> new RuntimeException("Funcionário não existe"));

		if (funcionarioRepo.existsByCpfAndIdFuncionarioNot(f.getCpf(), f.getIdFuncionario())) {
			throw new RuntimeException("Usuário com esse cpf já existe");
		}

		departamentoRepo.findById(f.getDepartamento().getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Departamento não existe"));

		funcionarioRepo.save(f);
	}

	/**
	 * Delete: Deleta um funcionário pelo seu ID.
	 * 
	 * @param id - O ID do funcionário a ser deletado.
	 * @throws RuntimeException se o funcionário não existir.
	 */
	public void deletarFuncionario(int id) {
		funcionarioRepo.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não existe"));

		funcionarioRepo.deleteById(id);
	}

}
