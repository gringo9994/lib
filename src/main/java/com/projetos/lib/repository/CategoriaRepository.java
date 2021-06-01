package com.projetos.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetos.lib.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	
	
	@Query(value = "select *from categorias as c where c.id=:id ",nativeQuery = true)
	Categoria findId(Long id);
	
}
