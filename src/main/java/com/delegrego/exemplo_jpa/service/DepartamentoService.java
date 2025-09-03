package com.delegrego.exemplo_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Departamento;
import com.delegrego.exemplo_jpa.repo.DepartamentoRepository;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

/**
 * Serviço para gerenciar operações relacionadas a Departamentos. Inclui métodos
 * para criar, ler, atualizar e deletar departamentos, além de validações
 * específicas.
 */

// Indica que esta classe é um serviço do Spring (camada de lógica de negócio)
@Service
public class DepartamentoService {

	// Autowired injeta automaticamente a interface de repositório que acessa o
	// banco de dados
	@Autowired
	private DepartamentoRepository departamentoRepo;

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	/**
	 * Create: Cadastra um novo departamento no sistema.
	 * 
	 * @param d - O departamento a ser cadastrado.
	 */
	public void cadastrarDepartamento(Departamento d) {
		departamentoRepo.save(d);
	}

	/**
	 * Read: Lista todos os departamentos cadastrados no sistema.
	 * 
	 * @return Uma lista de departamentos.
	 */
	public List<Departamento> listarDepartamentos() {
		return departamentoRepo.findAll();
	}

	/**
	 * Update: Atualiza as informações de um departamento existente.
	 * 
	 * @param d - O departamento com as informações atualizadas.
	 * @throws RuntimeException se o departamento não existir.
	 */
	public void atualizarDepartamento(Departamento d) {
		departamentoRepo.findById(d.getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Não existe esse departamento"));

		departamentoRepo.save(d);
	}

	/**
	 * Delete: Deleta um departamento pelo seu ID.
	 * 
	 * @param id - O ID do departamento a ser deletado.
	 * @throws RuntimeException se o departamento não existir ou se houver
	 *                          funcionários associados.
	 */
	public void deletarDepartamento(int id) {
		departamentoRepo.findById(id).orElseThrow(() -> new RuntimeException("Departamento não existe"));

		if (funcionarioRepo.existsByDepartamentoIdDepartamento(id)) {
			throw new RuntimeException("Não pode excluir departamentos com funcionários");
		}

		departamentoRepo.deleteById(id);
	}
}
