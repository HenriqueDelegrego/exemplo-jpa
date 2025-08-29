package com.delegrego.exemplo_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.delegrego.exemplo_jpa.model.Departamento;
import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.service.DepartamentoService;
import com.delegrego.exemplo_jpa.service.FuncionarioService;

/**
 * Controlador para executar operações iniciais na aplicação. Implementa
 * CommandLineRunner para executar código após o início da aplicação.
 */

// Indica que esta classe é um componente do Spring
@Component
public class Controller implements CommandLineRunner {

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private FuncionarioService funcionarioService;

	@Override
	public void run(String... args) {

		System.out.println("oi");

	}

}
