package com.delegrego.exemplo_jpa.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFuncionario;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "salario")
	private BigDecimal salario;

	@ManyToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
	private Departamento departamento;

	public Funcionario() {

	}

	public Funcionario(int idFuncionario, String nome, String cpf, BigDecimal salario, Departamento departamento) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.departamento = departamento;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", salario="
				+ salario + ", departamento=" + departamento + "]";
	}

}
