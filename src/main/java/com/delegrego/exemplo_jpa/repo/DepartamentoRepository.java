package com.delegrego.exemplo_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delegrego.exemplo_jpa.model.Departamento;

/**
 * Repositório JPA para a entidade Departamento. Extende JpaRepository para
 * fornecer operações CRUD e outras funcionalidades. O JpaRepository é
 * parametrizado com a entidade Departamento e o tipo da chave primária
 * (Integer).
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
