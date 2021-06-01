package com.projetos.lib.dtos;

import java.util.List;

import com.projetos.lib.models.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {
	
	
	public LivroDto(Livro obj) {
		// TODO Auto-generated constructor stub
	}

	private Long id;
	private String titulo;
	private String autor;
	private String descricao;

	private Long categoriaId;

}
