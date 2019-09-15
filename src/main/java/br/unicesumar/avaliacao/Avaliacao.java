package br.unicesumar.avaliacao;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao {
	@Id
	private String id;
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="avaliacao_id",nullable=false)
	private Set<Nota> notas = new HashSet<>();
	
	public Avaliacao() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Nota> getNota() {
		return notas;
	}
	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}

	
}
