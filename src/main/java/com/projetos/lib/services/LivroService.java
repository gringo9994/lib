package com.projetos.lib.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetos.lib.dtos.CategoriaDto;
import com.projetos.lib.dtos.LivroDto;
import com.projetos.lib.dtos.LivroDtoBusca;
import com.projetos.lib.models.Categoria;
import com.projetos.lib.models.Livro;
import com.projetos.lib.repository.CategoriaRepository;
import com.projetos.lib.repository.LivroRepository;
import com.projetos.lib.utils.ModelMapperUtils;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public LivroDto salvar(Long categoriaId, LivroDto dto) {
		@SuppressWarnings("unused")
		Livro livro = new Livro();

		Categoria categoria = categoriaService.getId(categoriaId);

		livro = Livro.builder().titulo(dto.getTitulo()).autor(dto.getAutor()).descricao(dto.getDescricao())
				.categorias(categoria).build();

		// livro.setCategorias(categoria);

		livroRepository.save(livro);

		return dto;
		
		
		
		
		
		

	}

	public List<LivroDtoBusca> getAll(Long categoriaId) {

		List<Livro> livros = livroRepository.getAllLivros(categoriaId);

		// List<LivroDtoBusca> livroDto=livros.stream().map(obj->new
		// LivroDtoBusca(obj)).collect((Collectors.toList()));

		return ModelMapperUtils.mapAll(livros, LivroDtoBusca.class);

		// return livroDto;

	}

	public List<Livro> all() {

		List<Livro> livro = livroRepository.findAll();

		return livro;

	}

	public Livro getLivro() {

		return null;

	}

	public LivroDto update(Long id, LivroDto dto) {

		@SuppressWarnings("unused")
		Livro livro = null;

		Categoria categoria = categoriaService.getId(dto.getCategoriaId());

		livro = Livro.builder().titulo(dto.getTitulo()).autor(dto.getAutor()).descricao(dto.getDescricao())
				.categorias(categoria).build();

		livro.setId(id);

		livroRepository.save(livro);

		return dto;
	}

	public LivroDto updateLivro (Long id,Long categoriaId, LivroDto dto) {
		
		
		Livro livro=null;
		
		livro=get(id);
		
		
		Categoria categoria = categoriaService.getId(categoriaId);
		livro=Livro.builder()
				.titulo(dto.getTitulo())
				.autor(dto.getAutor())
				.descricao(dto.getDescricao())
				.categorias(categoria).build();
		livro.setId(id);
		livroRepository.save(livro);
		
	
		

		return dto;
	}
	
	

	public Livro get(Long id) {

		Livro livro = livroRepository.getIdLivro(id);

		return livro;

	}

	public void delete(Long id) {

		Livro livro = livroRepository.getById(id);
		livroRepository.delete(livro);

	}

	public LivroDtoBusca getId(Long id) {

		Livro livro = livroRepository.getIdLivro(id);

		return ModelMapperUtils.map(livro, LivroDtoBusca.class);

	}
	
	
	
	
	

}
