package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empregado")
public class Empregado {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name  = "nome")
	private String nome;
	
	private int salario;

	public Empregado() {
	}

	public Empregado(String nome, int salario) {
		this.nome = nome;
		this.salario = salario;
	}

	// Getters e Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

}
