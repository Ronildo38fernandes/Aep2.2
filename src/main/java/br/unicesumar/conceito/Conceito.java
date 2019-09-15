package br.unicesumar.conceito;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import br.unicesumar.avaliacao.Avaliacao;
@Entity
public class Conceito {
	@Id
	private String id;
	private String nome;
	
	@ManyToMany
	@JoinTable(name="Avaliacoes",
			joinColumns = { @JoinColumn(name = "Conceito_id") },
			inverseJoinColumns = { @JoinColumn(name = "Avaliacao_id") })
	private Set<Avaliacao> provas = new HashSet<>();

	public Conceito() {
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
	
	public Set<Avaliacao> getAvaliacao() {
		return provas;
	}
	
	public void setProvas(Set<Avaliacao> prova) {
		this.provas = prova;
	}

}
