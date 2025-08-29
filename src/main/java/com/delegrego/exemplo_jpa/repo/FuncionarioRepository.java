package com.delegrego.exemplo_jpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delegrego.exemplo_jpa.model.Funcionario;

/**
 * Repositório JPA para a entidade Funcionario. Extende JpaRepository para
 * fornecer operações CRUD e outras funcionalidades. O JpaRepository é
 * parametrizado com a entidade Funcionario e o tipo da chave primária
 * (Integer).
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	// Derived queries

	/**
	 * Busca um funcionário pelo CPF.
	 * 
	 * @param cpf - CPF do funcionário a ser buscado.
	 * @return Optional contendo o funcionário, se encontrado.
	 */
	Optional<Funcionario> findByCpf(String cpf);

	/**
	 * Conta quantos funcionários pertencem a um determinado departamento.
	 * 
	 * @param id - ID do departamento.
	 * @return Número de funcionários no departamento.
	 */
	int countByDepartamento_IdDepartamento(int id);

	/**
	 * Verifica se existe um funcionário com o mesmo CPF, excluindo um ID
	 * específico. Útil para validação ao atualizar um funcionário.
	 * 
	 * @param cpf - CPF a ser verificado.
	 * @param id  - ID do funcionário a ser excluído da verificação.
	 * @return true se existir outro funcionário com o mesmo CPF, false caso
	 *         contrário.
	 */
	boolean existsByCpfAndIdFuncionarioNot(String cpf, int id);

}
