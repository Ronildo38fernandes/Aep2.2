package br.unicesumar.avaliacao;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nota {
	@Id
	private String id;
	private int valor;
	
	public Nota(int valor) {
		id = UUID.randomUUID().toString();
		if(valor < 0 && valor > 10 ) {
			throw new RuntimeException();
		}
		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
	public String getId() {
		return id;
	}
		
}
