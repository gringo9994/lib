package com.projetos.lib.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.lib.dtos.LivroDto;
import com.projetos.lib.dtos.LivroDtoBusca;
import com.projetos.lib.models.Livro;
import com.projetos.lib.services.LivroService;

@RestController
@RequestMapping(value = "/api/livros")

public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping(value = "/{categoriaId}")
	public ResponseEntity<LivroDto> salvar(@PathVariable("categoriaId") Long categoriaId, @RequestBody LivroDto dto) {

		LivroDto objetoLivro = livroService.salvar(categoriaId, dto);

		return ResponseEntity.ok(objetoLivro);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDto> updateLivro(@PathVariable("id") Long id, Long categoriaId,
			@RequestBody LivroDto dto) {

		LivroDto objetoLivro = livroService.updateLivro(id, categoriaId, dto);

		return ResponseEntity.ok(objetoLivro);

	}

	@GetMapping(value = "/{categoriaId}")
	public ResponseEntity<List<LivroDtoBusca>> getAll(@PathVariable("categoriaId") Long categoriaId) {

		List<LivroDtoBusca> objetoLivros = livroService.getAll(categoriaId);

		return ResponseEntity.ok(objetoLivros);

	}

	@GetMapping

	public ResponseEntity<List<Livro>> all() {

		List<Livro> livro = livroService.all();

		return ResponseEntity.ok(livro);

	}

	@GetMapping(value = "/busca/{id}")
	public ResponseEntity<LivroDtoBusca> get(@PathVariable("id") Long id) {

		LivroDtoBusca objetoLivro = livroService.getId(id);

		return ResponseEntity.ok(objetoLivro);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<LivroDto> update(@PathVariable("id") Long id, @RequestBody LivroDto dto) {

		LivroDto objetoLivro = livroService.update(id, dto);

		return ResponseEntity.ok(objetoLivro);

	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		livroService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
