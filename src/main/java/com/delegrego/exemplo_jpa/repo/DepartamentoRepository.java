package com.delegrego.exemplo_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delegrego.exemplo_jpa.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
