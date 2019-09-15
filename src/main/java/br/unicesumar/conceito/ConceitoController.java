package br.unicesumar.conceito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.avaliacao.Avaliacao;

@RestController
@RequestMapping("/api/conceito")
public class ConceitoController {
	@Autowired
	private ConceitoRepository repo;

	
	@GetMapping
	public List<Conceito> getAll() {
		return repo.findAll();
	}
	@PostMapping
	public String post(@RequestBody Conceito nova) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for (Avaliacao p : nova.getAvaliacao()) {
			System.out.println(p.getId());
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		repo.save(nova);
		return nova.getId();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repo.deleteById(id);
	}

	@GetMapping("/{id}")
	public Conceito getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
		@PutMapping("/{id}")
	public void put(@PathVariable("id") String id, @RequestBody Conceito conceito) {
		if (!id.equals(conceito.getId())) {
			throw new RuntimeException();
		}
		repo.save(conceito);
	}
	
	
}
 





