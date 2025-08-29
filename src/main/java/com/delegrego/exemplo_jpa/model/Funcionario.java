package com.delegrego.exemplo_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe que representa a entidade Funcionario no banco de dados.
 */

//Indica que esta classe é uma entidade JPA
@Entity

// Define o nome da tabela no banco de dados que esta entidade representa
@Table(name = "funcionario")
public class Funcionario {

	// Define o campo 'id' como a chave primária da tabela
	@Id
	
	// Especifica que o valor do campo 'id' será gerado automaticamente pelo banco
	// de dados
	// (AUTO_INCREMENT)
	// IDENTITY é o tipo utilizado no MySQL
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Mapeia o campo 'idFuncionario' para a coluna 'id_funcionario' na tabela
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "salario")
	private double salario;

	@ManyToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
	private Departamento departamento;

	// Construtor padrão (necessário para o JPA)
	public Funcionario() {

	}

	public Funcionario(int idFuncionario, String nome, String cpf, double salario, Departamento departamento) {
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
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
		return "\nID do funcionário: " + idFuncionario + "\nNome: " + nome + "\nCPF: " + cpf + "\nSalário: R$"
				+ salario + departamento;
	}

}
