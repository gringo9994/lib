package com.projetos.lib.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.lib.dtos.CategoriaDto;
import com.projetos.lib.models.Categoria;
import com.projetos.lib.repository.CategoriaRepository;
import com.projetos.lib.utils.ModelMapperUtils;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	// buscar varias categorias

	public List<Categoria> getCategorias(List<Long> ids) {

		return categoriaRepository.findAllById(ids);
	}

	public Categoria getId(Long id) {
		return categoriaRepository.findId(id);
	}
	
	
	public CategoriaDto get(Long id) {
		
		Categoria categoria= categoriaRepository.findId(id);
		
		
		return ModelMapperUtils.map(categoria, CategoriaDto.class);
		
	}
	
	
	

	public CategoriaDto salvar(CategoriaDto dto) {

		Categoria categoria = null;

		categoria = Categoria.builder().nome(dto.getNome()).descricao(dto.getDescricao()).build();

		categoriaRepository.save(categoria);

		return dto;
	}
	
	
	
	
	public CategoriaDto update (Long id, CategoriaDto dto) {
		

		Categoria categoria = null;

		categoria = Categoria.builder().nome(dto.getNome()).descricao(dto.getDescricao()).build();
		
		categoria.setId(id);

		categoriaRepository.save(categoria);
	

		return dto;
		
		
	}
	
	
	
	

	public List<CategoriaDto> getAll() {

		List<Categoria> categorias = categoriaRepository.findAll();

		return ModelMapperUtils.mapAll(categorias, CategoriaDto.class);

	}

	public void delete(Long id) {

		Categoria categoria = categoriaRepository.findId(id);

		categoriaRepository.delete(categoria);

	}

}
