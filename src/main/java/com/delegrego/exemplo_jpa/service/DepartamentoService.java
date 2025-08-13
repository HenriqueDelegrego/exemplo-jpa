package com.delegrego.exemplo_jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delegrego.exemplo_jpa.model.Departamento;
import com.delegrego.exemplo_jpa.repo.DepartamentoRepository;
import com.delegrego.exemplo_jpa.repo.FuncionarioRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepo;

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	public void cadastrarDepartamento(Departamento d) {
		departamentoRepo.save(d);
	}

	public List<Departamento> listarDepartamentos() {
		return departamentoRepo.findAll();
	}

	public Optional<Departamento> obterDepartamentoPorId(int id) {
		return departamentoRepo.findById(id);
	}

	public void atualizarDepartamento(Departamento d) {
		departamentoRepo.findById(d.getIdDepartamento())
				.orElseThrow(() -> new RuntimeException("Não existe esse departamento"));
		departamentoRepo.save(d);
	}

	public void deletarDepartamento(int id) {
		departamentoRepo.findById(id).orElseThrow(() -> new RuntimeException("Departamento não existe"));
		if (funcionarioRepo.countByDepartamento_IdDepartamento(id) > 0) {
			throw new RuntimeException("Não pode excluir departamentos com funcionários");
		}

		departamentoRepo.deleteById(id);
	}
}
