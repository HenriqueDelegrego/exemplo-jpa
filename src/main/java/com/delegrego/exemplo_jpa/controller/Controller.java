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

		// CRUD para Departamento

		// Create
		Departamento departamentoNovo = new Departamento();
		departamentoNovo.setNmDepartamento("Financeiro");
		departamentoService.cadastrarDepartamento(departamentoNovo);

		Departamento departamentoNovo2 = new Departamento();
		departamentoNovo2.setNmDepartamento("Desenvolvimento");
		departamentoService.cadastrarDepartamento(departamentoNovo2);

		Departamento departamentoNovo3 = new Departamento();
		departamentoNovo3.setNmDepartamento("RH");
		departamentoService.cadastrarDepartamento(departamentoNovo3);

		// Read
		System.out.println(departamentoService.listarDepartamentos());

		// Update
		Departamento departamentoAtualizado = new Departamento();
		departamentoAtualizado.setIdDepartamento(3);
		departamentoAtualizado.setNmDepartamento("Recursos Humanos");
		departamentoService.atualizarDepartamento(departamentoAtualizado);

		// Delete
		departamentoService.deletarDepartamento(3);

		// CRUD para Funcionario

		// Create
		Departamento departamentoFuncionario = new Departamento();
		departamentoFuncionario.setIdDepartamento(1);

		Funcionario funcionarioNovo = new Funcionario();
		funcionarioNovo.setNome("João");
		funcionarioNovo.setCpf("123");
		funcionarioNovo.setSalario(5000);
		funcionarioNovo.setDepartamento(departamentoFuncionario);
		funcionarioService.cadastrarFuncionario(funcionarioNovo);

		// Read
		System.out.println(funcionarioService.listarFuncionarios());

		// Update
		Departamento departamentoFuncionarioAtualizado = new Departamento();
		departamentoFuncionarioAtualizado.setIdDepartamento(2);

		Funcionario funcionarioAtualizado = new Funcionario();
		funcionarioAtualizado.setIdFuncionario(1);
		funcionarioAtualizado.setNome("João Da Silva");
		funcionarioAtualizado.setCpf("1234");
		funcionarioAtualizado.setSalario(5500);
		funcionarioAtualizado.setDepartamento(departamentoFuncionarioAtualizado);
		funcionarioService.atualizarFuncionario(funcionarioAtualizado);

		// Delete
		funcionarioService.deletarFuncionario(1);

	}

}
