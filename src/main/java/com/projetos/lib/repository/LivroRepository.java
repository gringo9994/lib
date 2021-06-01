package com.projetos.lib.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetos.lib.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = "select *from livros as l where l.id=:id ", nativeQuery = true)
Livro getIdLivro(Long id);
	
	
	@Query(value = "select * from livros as l where l.categoria_id=:categoriaId", nativeQuery = true)
	List<Livro> getAllLivros(Long categoriaId);

	
	
	

}
