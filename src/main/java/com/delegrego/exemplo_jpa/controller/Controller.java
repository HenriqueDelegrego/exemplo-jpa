package com.delegrego.exemplo_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.delegrego.exemplo_jpa.model.Departamento;
import com.delegrego.exemplo_jpa.model.Funcionario;
import com.delegrego.exemplo_jpa.service.DepartamentoService;
import com.delegrego.exemplo_jpa.service.FuncionarioService;

@Component
public class Controller implements CommandLineRunner {

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private FuncionarioService funcionarioService;

	@Override
	public void run(String... args) {

		Funcionario f = new Funcionario();

		f.setIdFuncionario(3);
		f.setNome("Jorginho");
		f.setCpf("1234");
		f.setSalario(5500);

		Departamento d = new Departamento();
		d.setIdDepartamento(2);

		f.setDepartamento(d);

		funcionarioService.atualizarFuncionario(f);

	}

}
