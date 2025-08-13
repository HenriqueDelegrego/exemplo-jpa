package com.delegrego.exemplo_jpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delegrego.exemplo_jpa.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	Optional<Funcionario> findByCpf(String cpf);

	int countByDepartamento_IdDepartamento(int id);
	
	boolean existsByCpfAndIdFuncionarioNot(String cpf, int id);


}
