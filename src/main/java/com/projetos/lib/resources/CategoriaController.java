package com.projetos.lib.resources;

import java.util.List;

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

import com.projetos.lib.dtos.CategoriaDto;
import com.projetos.lib.models.Categoria;
import com.projetos.lib.services.CategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<CategoriaDto> salvar( @RequestBody          CategoriaDto dto) {
		CategoriaDto objetoCategoria = categoriaService.salvar(dto);

		return ResponseEntity.ok(objetoCategoria);

	}

	@GetMapping
	public ResponseEntity<List<CategoriaDto>> getAll() {

		List<CategoriaDto> categorias = categoriaService.getAll();

		return ResponseEntity.ok(categorias);

	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDto>get(@PathVariable("id")   Long id){
		
		CategoriaDto objetoCat=categoriaService.get(id);
		
		
		return ResponseEntity.ok(objetoCat);
		
		
	}

	@PutMapping(value = "/{id}")
	public  ResponseEntity<CategoriaDto>  update( @PathVariable("id")  Long id,   @RequestBody    CategoriaDto dto) {
		
		CategoriaDto objetoCat=categoriaService.update(id, dto);
		
		
		return ResponseEntity.ok(objetoCat);
		
	}
	
	
	
	
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable("id")  Long id) {

		categoriaService.delete(id);

		return ResponseEntity.noContent().build();

	}
	
	
	
	
	
	

}
